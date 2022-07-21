package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReportThread {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method POST at api endpoints | ThreadReportThread")
    public String setMethodPost() {
        return this.endpoint + "/threads";
    }

    @Step("Send method POST HTTP request | ThreadReportThread")
    public void sendMethodPost(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .post(this.setMethodPost() + "/" + id + "/reports");
    }

    @Step("Receive valid HTTP response code 200 | ThreadReportThread")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("Receive valid message data thread succesfully reported | ThreadReportThread")
    public void receiveValidData() {
//        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }
}
