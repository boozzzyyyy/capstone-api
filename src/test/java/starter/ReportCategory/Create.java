package starter.ReportCategory;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Create {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";
    public static String name = "";

    @Step("Set method POST at api endpoints | ReportCategoryCreate")
    public String setMethodPost() {
        return this.endpoint + "/report-categories";
    }

    @Step("Send method POST HTTP request | ReportCategoryCreate")
    public void sendMethodPost(String token, String name) {

        this.name = name;

        JSONObject requestBody = new JSONObject();
        requestBody.put("name",name);
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(this.setMethodPost());
    }

    @Step("Receive valid HTTP response code 200 | ReportCategoryCreate")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message data report category succesfully created | ReportCategoryCreate")
    public void receiveValidData() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }

    @Step("Validate data report category created | ReportCategoryCreate")
    public void validateDataCreated(String token) {
        List<HashMap<String, Object>> jsonObjects = SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .get(this.setMethodPost())
                .jsonPath()
                .get("Data");

        restAssuredThat(response -> response.body("Data[" + (jsonObjects.size() - 1) + "].name", equalTo(this.name)));
    }
}
