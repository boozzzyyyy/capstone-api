package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Thread.UndoDownvotes;

public class ThreadUndoDownvotesSteps {
    @Steps
    Login Login;

    @Steps
    UndoDownvotes ThreadUndoDownvotes;

    public static String token = "";

    @Given("Get token from login | ThreadUndoDownvotes")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method DELETE at api endpoints | ThreadUndoDownvotes")
    public void setMethodDelete() {
        ThreadUndoDownvotes.setMethodDelete();
    }

    @And("Send method DELETE HTTP request | ThreadUndoDownvotes")
    public void sendMethodDelete() {
        ThreadUndoDownvotes.sendMethodDelete(this.token, 1);
    }

    @And("Receive valid HTTP response code 200 | ThreadUndoDownvotes")
    public void receiveValidHTTP() {
        ThreadUndoDownvotes.receiveValidHTTP();
    }

    @Then("Receive valid message data thread succesfully undo down voted | ThreadUndoDownvotes")
    public void receiveValidData() {
        ThreadUndoDownvotes.receiveValidData();
    }
}
