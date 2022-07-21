package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Report.User;

public class ReportUserSteps {
    @Steps
    Login Login;

    @Steps
    User ReportUser;

    public static String token = "";

    @Given("Get token from login | ReportUser")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ReportUser")
    public void setMethodPost() {
        ReportUser.setMethodPost();
    }

    @And("Send method POST HTTP request | ReportUser")
    public void sendMethodPost() {
        ReportUser.sendMethodPost(this.token, 2, 3);
    }

    @And("Receive valid HTTP response code 200 | ReportUser")
    public void receiveValidHTTP() {
        ReportUser.receiveValidHTTP();
    }

    @Then("Receive valid message report success | ReportUser")
    public void receiveValidMessage() {
        ReportUser.receiveValidMessage();
    }
}
