package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Helper.Main;
import starter.Thread.Delete;

public class ThreadDeleteSteps {
    @Steps
    Login Login;

    @Steps
    Delete ThreadDelete;

    public static String token = "";

    @Given("Get token from login | ThreadDelete")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method DELETE at api endpoints | ThreadDelete")
    public void setMethodDelete() {
        ThreadDelete.setMethodDelete();
    }

    @And("Send method DELETE HTTP request | ThreadDelete")
    public void sendMethodDelete() {
        ThreadDelete.sendMethodDelete(this.token, 5);
    }

    @And("Receive valid HTTP response code 200 | ThreadDelete")
    public void receiveValidHTTP() {
        ThreadDelete.receiveValidHTTP();
    }

    @Then("Receive valid message data thread succesfully deleted | ThreadDelete")
    public void receiveValidData() {
        ThreadDelete.receiveValidData();
    }
}
