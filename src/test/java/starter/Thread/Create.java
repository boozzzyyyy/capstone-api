package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Create {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";
    public static String titleGlobal = "";
    @Step("Set method POST at api endpoints | ThreadCreate")
    public String setMethodPost() {
        return this.endpoint + "/threads";
    }

    @Step("Send method POST HTTP request | ThreadCreate")
    public void sendMethodPost(String token, String title, String body, Integer communityId) {
        JSONObject requestBody = new JSONObject();
        this.titleGlobal = title;
        requestBody.put("title",title);
        requestBody.put("body",body);
        requestBody.put("communityID",communityId);

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(this.setMethodPost());
    }

    @Step("Receive valid HTTP response code 200 | ThreadCreate")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message data thread succesfully created | ThreadCreate")
    public void receiveValidData() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data.title", equalTo(this.titleGlobal)));
    }

    @Step("Validate data thread created | ThreadCreate")
    public void validateDataCreated(String token) {
        List<HashMap<String, Object>> jsonObjects = SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .get(this.setMethodPost())
                .jsonPath()
                .get("Data");

        restAssuredThat(response -> response.body("Data[" + (jsonObjects.size() - 1) + "].title", equalTo(this.titleGlobal)));
    }
}
