package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Follow.FollowUser;

public class FollowFollowUserSteps {
    @Steps
    Login Login;

    @Steps
    FollowUser FollowUser;

    public static String token = "";

    @Given("Get token from login | FollowFollowUser")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | FollowFollowUser")
    public void setMethodPost() {
        FollowUser.setMethodPost();
    }

    @And("Send method POST HTTP request | FollowFollowUser")
    public void sendMethodPost() {
        FollowUser.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | FollowFollowUser")
    public void receiveValidHTTP() {
        FollowUser.receiveValidHTTP();
    }

    @Then("Receive valid message user succesfully followed | FollowFollowUser")
    public void receiveValidMessage() {
        FollowUser.receiveValidMessage();
    }
}
