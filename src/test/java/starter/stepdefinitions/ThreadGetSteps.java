package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.Get;

public class ThreadGetSteps {
    @Steps
    Login Login;

    @Steps
    Get ThreadGet;

    public static String token = "";

    @Given("Get token from login | ThreadGet")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method GET at api endpoints | ThreadGet")
    public void setMethodGet() {
        ThreadGet.setMethodGet();
    }

    @And("Send method GET HTTP request | ThreadGet")
    public void sendMethodGet() {
        ThreadGet.sendMethodGet(this.token, 10, "", true, "", "");
    }

    @And("Receive valid HTTP response code 200 | ThreadGet")
    public void receiveValidHTTP() {
        ThreadGet.receiveValidHTTP();
    }

    @Then("Receive valid data thread succesfully | ThreadGet")
    public void receiveValidData() {
        ThreadGet.receiveValidData();
    }
}
