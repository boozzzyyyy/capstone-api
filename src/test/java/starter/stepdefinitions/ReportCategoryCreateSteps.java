package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.ReportCategory.Create;
import starter.Helper.Main;

public class ReportCategoryCreateSteps {
    @Steps
    Login Login;

    @Steps
    Create ReportCategoryCreate;

    public static String token = "";

    @Given("Get token from login | ReportCategoryCreate")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ReportCategoryCreate")
    public void setMethodPost() {
        ReportCategoryCreate.setMethodPost();
    }

    @And("Send method POST HTTP request | ReportCategoryCreate")
    public void sendMethodPost() {
        Main MainHelper = new Main();
        String reportCategoryName = "Create Report Category Test " + MainHelper.randomCharacter(10, false);
        ReportCategoryCreate.sendMethodPost(this.token, reportCategoryName);
    }

    @And("Receive valid HTTP response code 200 | ReportCategoryCreate")
    public void receiveValidHTTP() {
        ReportCategoryCreate.receiveValidHTTP();
    }

    @And("Receive valid message data report category succesfully created | ReportCategoryCreate")
    public void receiveValidData() {
        ReportCategoryCreate.receiveValidData();
    }

    @Then("Validate data report category created | ReportCategoryCreate")
    public void validateDataCreated() {
        ReportCategoryCreate.validateDataCreated(this.token);
    }
}
