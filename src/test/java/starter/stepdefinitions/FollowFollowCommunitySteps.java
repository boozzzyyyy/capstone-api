package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Follow.FollowCommunity;

public class FollowFollowCommunitySteps {
    @Steps
    Login Login;

    @Steps
    FollowCommunity FollowCommunity;

    public static String token = "";

    @Given("Get token from login | FollowFollowCommunity")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | FollowFollowCommunity")
    public void setMethodPost() {
        FollowCommunity.setMethodPost();
    }

    @And("Send method POST HTTP request | FollowFollowCommunity")
    public void sendMethodPost() {
        FollowCommunity.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | FollowFollowCommunity")
    public void receiveValidHTTP() {
        FollowCommunity.receiveValidHTTP();
    }

    @Then("Receive valid message community succesfully followed | FollowFollowCommunity")
    public void receiveValidMessage() {
        FollowCommunity.receiveValidMessage();
    }
}
