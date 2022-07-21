package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SetImage {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method PUT at api endpoints | ThreadUpdate")
    public String setMethodPut() {
        return this.endpoint + "/threads";
    }

    @Step("Send method PUT HTTP request | ThreadUpdate")
    public void sendMethodPut(String token, Integer threadId, String threadImage) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("threadImg",threadImage);

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .put(this.setMethodPut() + "/" + threadId + "/images");
    }

    @Step("Receive valid HTTP response code 200 | ThreadUpdate")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message data thread succesfully updated | ThreadUpdate")
    public void receiveValidMessage() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data.title", equalTo(null)));
    }
}
