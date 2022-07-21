package starter.ReportCategory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method GET at api endpoints | ReportCategoryGet")
    public String setMethodGet() {
        return this.endpoint + "/report-categories";
    }

    @Step("Send method GET HTTP request | ReportCategoryGet")
    public void sendMethodGet(String token) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .get(this.setMethodGet());
    }

    @Step("Receive valid HTTP response code 200 | ReportCategoryGet")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid data report category succesfully | ReportCategoryGet")
    public void receiveValidData() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data[0].ID", equalTo(1)));
    }
}
