package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.GetSaveThread;

public class ThreadGetSaveThreadSteps {
    @Steps
    Login Login;

    @Steps
    GetSaveThread ThreadGetSaveThread;

    public static String token = "";

    @Given("Get token from login | ThreadGetSaveThread")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method GET at api endpoints | ThreadGetSaveThread")
    public void setMethodGet() {
        ThreadGetSaveThread.setMethodGet();
    }

    @And("Send method GET HTTP request | ThreadGetSaveThread")
    public void sendMethodGet() {
        ThreadGetSaveThread.sendMethodGet(this.token);
    }

    @And("Receive valid HTTP response code 200 | ThreadGetSaveThread")
    public void receiveValidHTTP() {
        ThreadGetSaveThread.receiveValidHTTP();
    }

    @Then("Receive valid data thread succesfully | ThreadGetSaveThread")
    public void receiveValidData() {
        ThreadGetSaveThread.receiveValidData();
    }
}
