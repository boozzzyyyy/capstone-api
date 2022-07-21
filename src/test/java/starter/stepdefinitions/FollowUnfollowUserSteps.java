package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Follow.UnfollowUser;

public class FollowUnfollowUserSteps {
    @Steps
    Login Login;

    @Steps
    UnfollowUser UnfollowUser;

    public static String token = "";

    @Given("Get token from login | FollowUnfollowUser")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | FollowUnfollowUser")
    public void setMethodPost() {
        UnfollowUser.setMethodPost();
    }

    @And("Send method POST HTTP request | FollowUnfollowUser")
    public void sendMethodPost() {
        UnfollowUser.sendMethodPost(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | FollowUnfollowUser")
    public void receiveValidHTTP() {
        UnfollowUser.receiveValidHTTP();
    }

    @Then("Receive valid message user succesfully unfollowed | FollowUnfollowUser")
    public void receiveValidMessage() {
        UnfollowUser.receiveValidMessage();
    }
}
