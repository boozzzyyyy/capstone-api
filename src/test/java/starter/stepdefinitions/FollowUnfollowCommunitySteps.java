package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Follow.UnfollowCommunity;

public class FollowUnfollowCommunitySteps {
    @Steps
    Login Login;

    @Steps
    UnfollowCommunity UnfollowCommunity;

    public static String token = "";

    @Given("Get token from login | FollowUnfollowCommunity")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | FollowUnfollowCommunity")
    public void setMethodPost() {
        UnfollowCommunity.setMethodPost();
    }

    @And("Send method POST HTTP request | FollowUnfollowCommunity")
    public void sendMethodPost() {
        UnfollowCommunity.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | FollowUnfollowCommunity")
    public void receiveValidHTTP() {
        UnfollowCommunity.receiveValidHTTP();
    }

    @Then("Receive valid message community succesfully unfollowed | FollowUnfollowCommunity")
    public void receiveValidMessage() {
        UnfollowCommunity.receiveValidMessage();
    }
}
