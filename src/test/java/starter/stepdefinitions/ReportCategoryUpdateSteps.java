package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Helper.Main;
import starter.ReportCategory.Update;

public class ReportCategoryUpdateSteps {
    @Steps
    Login Login;

    @Steps
    Update ReportCategoryUpdate;

    public static String token = "";

    @Given("Get token from login | ReportCategoryUpdate")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method PUT at api endpoints | ReportCategoryUpdate")
    public void setMethodPut() {
        ReportCategoryUpdate.setMethodPut();
    }

    @And("Send method PUT HTTP request | ReportCategoryUpdate")
    public void sendMethodPut() {
        Main MainHelper = new Main();
        String reportCategoryName = "Update Report Category Test " + MainHelper.randomCharacter(10, false);
        ReportCategoryUpdate.sendMethodPut(this.token, 1, reportCategoryName);
    }

    @And("Receive valid HTTP response code 200 | ReportCategoryUpdate")
    public void receiveValidHTTP() {
        ReportCategoryUpdate.receiveValidHTTP();
    }

    @And("Receive valid message data report category succesfully updated | ReportCategoryUpdate")
    public void receiveValidData() {
        ReportCategoryUpdate.receiveValidData();
    }

    @Then("Validate data report category updated | ReportCategoryUpdate")
    public void validateDataUpdated() {
        ReportCategoryUpdate.validateDataUpdated(this.token, 1);
    }
}
