package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.UndoUpvotes;

public class ThreadUndoUpvotesSteps {
    @Steps
    Login Login;

    @Steps
    UndoUpvotes ThreadUndoUpvotes;

    public static String token = "";

    @Given("Get token from login | ThreadUndoUpvotes")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method DELETE at api endpoints | ThreadUndoUpvotes")
    public void setMethodDelete() {
        ThreadUndoUpvotes.setMethodDelete();
    }

    @And("Send method DELETE HTTP request | ThreadUndoUpvotes")
    public void sendMethodDelete() {
        ThreadUndoUpvotes.sendMethodDelete(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadUndoUpvotes")
    public void receiveValidHTTP() {
        ThreadUndoUpvotes.receiveValidHTTP();
    }

    @Then("Receive valid message data thread succesfully undo up voted | ThreadUndoUpvotes")
    public void receiveValidData() {
        ThreadUndoUpvotes.receiveValidData();
    }
}
