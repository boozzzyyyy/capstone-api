package starter.ReportCategory;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Update {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";
    public static String name = "";

    @Step("Set method PUT at api endpoints | ReportCategoryUpdate")
    public String setMethodPut() {
        return this.endpoint + "/report-categories";
    }

    @Step("Send method PUT HTTP request | ReportCategoryUpdate")
    public void sendMethodPut(String token, Integer id, String name) {
        this.name = name;

        JSONObject requestBody = new JSONObject();
        requestBody.put("name",name);

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .put(this.setMethodPut() + "/" + id);
    }

    @Step("Receive valid HTTP response code 200 | ReportCategoryUpdate")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message data report category succesfully updated | ReportCategoryUpdate")
    public void receiveValidData() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }

    @Step("Validate data report category updated | ReportCategoryUpdate")
    public void validateDataUpdated(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .get(this.setMethodPut() + "/" + id);

        restAssuredThat(response -> response.body("Data.name", equalTo(this.name)));
    }
}
