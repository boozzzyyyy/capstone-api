package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Helper.Main;
import starter.Thread.ReportThread;

public class ThreadReportThreadSteps {
    @Steps
    Login Login;

    @Steps
    ReportThread ThreadReportThread;

    public static String token = "";

    @Given("Get token from login | ThreadReportThread")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ThreadReportThread")
    public void setMethodPost() {
        ThreadReportThread.setMethodPost();
    }

    @And("Send method POST HTTP request | ThreadReportThread")
    public void sendMethodPost() {
        ThreadReportThread.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadReportThread")
    public void receiveValidHTTP() {
        ThreadReportThread.receiveValidHTTP();
    }

    @Then("Receive valid message data thread succesfully reported | ThreadReportThread")
    public void receiveValidData() {
        ThreadReportThread.receiveValidData();
    }
}
