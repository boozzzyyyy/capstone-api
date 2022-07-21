package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.ReportCategory.Detail;

public class ReportCategoryDetailSteps {
    @Steps
    Login Login;

    @Steps
    Detail ReportCategoryDetail;

    public static String token = "";

    @Given("Get token from login | ReportCategoryDetail")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method GET at api endpoints | ReportCategoryDetail")
    public void setMethodGet() {
        ReportCategoryDetail.setMethodGet();
    }

    @And("Send method GET HTTP request | ReportCategoryDetail")
    public void sendMethodGet() {
        ReportCategoryDetail.sendMethodGet(this.token);
    }

    @And("Receive valid HTTP response code 200 | ReportCategoryDetail")
    public void receiveValidHTTP() {
        ReportCategoryDetail.receiveValidHTTP();
    }

    @Then("Receive valid detail data report category succesfully | ReportCategoryDetail")
    public void receiveValidData() {
        ReportCategoryDetail.receiveValidData();
    }
}
