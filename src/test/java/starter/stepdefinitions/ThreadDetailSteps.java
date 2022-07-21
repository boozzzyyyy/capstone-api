package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.Detail;

public class ThreadDetailSteps {
    @Steps
    Login Login;

    @Steps
    Detail ThreadDetail;

    public static String token = "";

    @Given("Get token from login | ThreadDetail")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method GET at api endpoints | ThreadDetail")
    public void setMethodGet() {
        ThreadDetail.setMethodGet();
    }

    @And("Send method GET HTTP request | ThreadDetail")
    public void sendMethodGet() {
        ThreadDetail.sendMethodGet(this.token);
    }

    @And("Receive valid HTTP response code 200 | ThreadDetail")
    public void receiveValidHTTP() {
        ThreadDetail.receiveValidHTTP();
    }

    @Then("Receive valid detail data thread succesfully | ThreadDetail")
    public void receiveValidData() {
        ThreadDetail.receiveValidData();
    }
}
