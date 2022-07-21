package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetSaveThread {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method GET at api endpoints | ThreadGetSaveThread")
    public String setMethodGet() {
        return this.endpoint + "/threads/saved";
    }

    @Step("Send method GET HTTP request | ThreadGetSaveThread")
    public void sendMethodGet(String token) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .get(this.setMethodGet());
    }

    @Step("Receive valid HTTP response code 200 | ThreadGetSaveThread")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid data thread succesfully | ThreadGetSaveThread")
    public void receiveValidData() {
//        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }
}
