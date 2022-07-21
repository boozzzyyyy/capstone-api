package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.ReportCategory.Get;

public class ReportCategoryGetSteps {
    @Steps
    Login Login;

    @Steps
    Get ReportCategoryGet;

    public static String token = "";

    @Given("Get token from login | ReportCategoryGet")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method GET at api endpoints | ReportCategoryGet")
    public void setMethodGet() {
        ReportCategoryGet.setMethodGet();
    }

    @And("Send method GET HTTP request | ReportCategoryGet")
    public void sendMethodGet() {
        ReportCategoryGet.sendMethodGet(this.token);
    }

    @And("Receive valid HTTP response code 200 | ReportCategoryGet")
    public void receiveValidHTTP() {
        ReportCategoryGet.receiveValidHTTP();
    }

    @Then("Receive valid data report category succesfully | ReportCategoryGet")
    public void receiveValidData() {
        ReportCategoryGet.receiveValidData();
    }
}
