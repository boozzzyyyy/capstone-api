package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class UndoDownvotes {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method DELETE at api endpoints | ThreadUndoDownvotes")
    public String setMethodDelete() {
        return this.endpoint + "/threads";
    }

    @Step("Send method DELETE HTTP request | ThreadUndoDownvotes")
    public void sendMethodDelete(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .delete(this.setMethodDelete() + "/" + id + "/downvotes");
    }

    @Step("Receive valid HTTP response code 200 | ThreadUndoDownvotes")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message data thread succesfully undo down voted | ThreadUndoDownvotes")
    public void receiveValidData() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data", equalTo(null)));
    }
}
