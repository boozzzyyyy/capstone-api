package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.SaveThread;

public class ThreadSaveThreadSteps {
    @Steps
    Login Login;

    @Steps
    SaveThread ThreadSaveThread;

    public static String token = "";

    @Given("Get token from login | ThreadSaveThread")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ThreadSaveThread")
    public void setMethodPost() {
        ThreadSaveThread.setMethodPost();
    }

    @And("Send method POST HTTP request | ThreadSaveThread")
    public void sendMethodPost() {
        ThreadSaveThread.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadSaveThread")
    public void receiveValidHTTP() {
        ThreadSaveThread.receiveValidHTTP();
    }

    @Then("Receive valid message data thread succesfully saved | ThreadSaveThread")
    public void receiveValidData() {
        ThreadSaveThread.receiveValidData();
    }
}
