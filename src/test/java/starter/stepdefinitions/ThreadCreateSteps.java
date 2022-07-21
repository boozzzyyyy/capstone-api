package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Helper.Main;
import starter.Thread.Create;

public class ThreadCreateSteps {
    @Steps
    Login Login;

    @Steps
    Create ThreadCreate;

    public static String token = "";

    @Given("Get token from login | ThreadCreate")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ThreadCreate")
    public void setMethodPost() {
        ThreadCreate.setMethodPost();
    }

    @And("Send method POST HTTP request | ThreadCreate")
    public void sendMethodPost() {
        Main MainHelper = new Main();
        String threadTitle = "Create Title Thread Test " + MainHelper.randomCharacter(10, false);
        String threadBody = "Create Body Thread Test " + MainHelper.randomCharacter(10, false);
        ThreadCreate.sendMethodPost(this.token, threadTitle, threadBody, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadCreate")
    public void receiveValidHTTP() {
        ThreadCreate.receiveValidHTTP();
    }

    @And("Receive valid message data thread succesfully created | ThreadCreate")
    public void receiveValidData() {
        ThreadCreate.receiveValidData();
    }

    @Then("Validate data thread created | ThreadCreate")
    public void validateDataCreated() {
        ThreadCreate.validateDataCreated(this.token);
    }
}
