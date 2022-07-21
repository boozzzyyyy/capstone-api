package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Report.Thread;

public class ReportThreadSteps {
    @Steps
    Login Login;

    @Steps
    Thread ReportThread;

    public static String token = "";

    @Given("Get token from login | ReportThread")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method GET at api endpoints | ReportThread")
    public void setMethodGet() {
        ReportThread.setMethodGet();
    }

    @And("Send method GET HTTP request | ReportThread")
    public void sendMethodGet() {
        ReportThread.sendMethodGet(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | ReportThread")
    public void receiveValidHTTP() {
        ReportThread.receiveValidHTTP();
    }

    @Then("Receive valid message data thread reported | ReportThread")
    public void receiveValidData() {
        ReportThread.receiveValidData();
    }
}
