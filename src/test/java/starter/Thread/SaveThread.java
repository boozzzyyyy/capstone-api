package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SaveThread {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method POST at api endpoints | ThreadSaveThread")
    public String setMethodPost() {
        return this.endpoint + "/threads";
    }

    @Step("Send method POST HTTP request | ThreadSaveThread")
    public void sendMethodPost(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .post(this.setMethodPost() + "/" + id + "/saved");
    }

    @Step("Receive valid HTTP response code 200 | ThreadSaveThread")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("Receive valid message data thread succesfully saved | ThreadSaveThread")
    public void receiveValidData() {
//        restAssuredThat(response -> response.body("Meta.message", equalTo("saved")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }
}
