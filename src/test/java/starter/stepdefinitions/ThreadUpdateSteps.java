package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Helper.Main;
import starter.Thread.Update;

public class ThreadUpdateSteps {
    @Steps
    Login Login;

    @Steps
    Update ThreadUpdate;

    public static String token = "";

    @Given("Get token from login | ThreadUpdate")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method POST at api endpoints | ThreadUpdate")
    public void setMethodPost() {
        ThreadUpdate.setMethodPost();
    }

    @And("Send method POST HTTP request | ThreadUpdate")
    public void sendMethodPost() {
        Main MainHelper = new Main();
        String threadTitle = "Update Title Thread Test " + MainHelper.randomCharacter(10, false);
        String threadBody = "Update Body Thread Test " + MainHelper.randomCharacter(10, false);
        ThreadUpdate.sendMethodPost(this.token, threadTitle, threadBody, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadUpdate")
    public void receiveValidHTTP() {
        ThreadUpdate.receiveValidHTTP();
    }

    @And("Receive valid message data thread succesfully updated | ThreadUpdate")
    public void receiveValidData() {
        ThreadUpdate.receiveValidData();
    }

    @Then("Validate data thread updated | ThreadUpdate")
    public void validateDataUpdated() {
        ThreadUpdate.validateDataUpdated(this.token);
    }
}
