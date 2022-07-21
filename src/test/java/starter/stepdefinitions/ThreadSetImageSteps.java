package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth.Login;
import starter.Helper.Main;
import starter.Thread.SetImage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThreadSetImageSteps {
    @Steps
    Login Login;

    @Steps
    SetImage ThreadSetImage;

    public static String token = "";

    @Given("Get token from login | ThreadSetImage")
    public void getTokenFromLogin() {
        this.token = Login.loginGetToken();
    }

    @When("Set method PUT at api endpoints | ThreadSetImage")
    public void setMethodPut() {
        ThreadSetImage.setMethodPut();
    }

    @And("Send method PUT HTTP request | ThreadSetImage")
    public void sendMethodPut() throws IOException {
        String payload = new String(Files.readAllBytes(Paths.get("path_to_file")));
        ThreadSetImage.sendMethodPut(this.token, 1, payload);
    }

    @And("Receive valid HTTP response code 200 | ThreadSetImage")
    public void receiveValidHTTP() {
        ThreadSetImage.receiveValidHTTP();
    }

    @Then("Receive valid message image thread succesfully updated | ThreadSetImage")
    public void receiveValidMessage() {
        ThreadSetImage.receiveValidMessage();
    }
}
