package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.Upvotes;

public class ThreadUpvotesSteps {
    @Steps
    Login Login;

    @Steps
    Upvotes ThreadUpvotes;

    public static String token = "";

    @Given("Get token from login | ThreadUpvotes")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ThreadUpvotes")
    public void setMethodPost() {
        ThreadUpvotes.setMethodPost();
    }

    @And("Send method POST HTTP request | ThreadUpvotes")
    public void sendMethodPost() {
        ThreadUpvotes.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadUpvotes")
    public void receiveValidHTTP() {
        ThreadUpvotes.receiveValidHTTP();
    }

    @Then("Receive valid message data thread succesfully up voted | ThreadUpvotes")
    public void receiveValidData() {
        ThreadUpvotes.receiveValidData();
    }
}
