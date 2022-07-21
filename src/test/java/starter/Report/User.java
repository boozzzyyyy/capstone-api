package starter.Report;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class User {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";
    public static String titleGlobal = "";

    @Step("Set method POST at api endpoints | ReportUser")
    public String setMethodPost() {
        return this.endpoint + "/report";
    }

    @Step("Send method POST HTTP request | ReportUser")
    public void sendMethodPost(String token, Integer userId, Integer reportCategoryId) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userID",userId);
        requestBody.put("reportCategoryID",reportCategoryId);

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(this.setMethodPost());
    }

    @Step("Receive valid HTTP response code 200 | ReportUser")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message report success | ReportUser")
    public void receiveValidMessage() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data.title", equalTo(null)));
    }
}
