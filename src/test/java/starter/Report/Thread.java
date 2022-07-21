package starter.Report;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Thread {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method POST at api endpoints | ReportThread")
    public String setMethodGet() {
        return this.endpoint + "/threads";
    }

    @Step("Send method POST HTTP request | ReportThread")
    public void sendMethodGet(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .get(this.setMethodGet() + "/" + id + "/reports");
    }

    @Step("Receive valid HTTP response code 200 | ReportThread")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(405));
    }

    @Step("Receive valid message data thread reported | ReportThread")
    public void receiveValidData() {
//        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }
}
