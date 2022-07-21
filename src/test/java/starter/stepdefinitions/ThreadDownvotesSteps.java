package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.Downvotes;

public class ThreadDownvotesSteps {
    @Steps
    Login Login;

    @Steps
    Downvotes ThreadDownvotes;

    public static String token = "";

    @Given("Get token from login | ThreadDownvotes")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ThreadDownvotes")
    public void setMethodPost() {
        ThreadDownvotes.setMethodPost();
    }

    @And("Send method POST HTTP request | ThreadDownvotes")
    public void sendMethodPost() {
        ThreadDownvotes.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadDownvotes")
    public void receiveValidHTTP() {
        ThreadDownvotes.receiveValidHTTP();
    }

    @Then("Receive valid message data thread succesfully down voted | ThreadDownvotes")
    public void receiveValidData() {
        ThreadDownvotes.receiveValidData();
    }
}
