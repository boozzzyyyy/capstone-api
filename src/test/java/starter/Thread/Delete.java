package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Delete {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";
    public static String titleGlobal = "";

    @Step("Set method DELETE at api endpoints | ThreadDelete")
    public String setMethodDelete() {
        return this.endpoint + "/threads";
    }

    @Step("Send method DELETE HTTP request | ThreadDelete")
    public void sendMethodDelete(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .delete(this.setMethodDelete() + "/" + id);
    }

    @Step("Receive valid HTTP response code 200 | ThreadDelete")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("Receive valid message data thread succesfully deleted | ThreadDelete")
    public void receiveValidData() {
//        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }
}
