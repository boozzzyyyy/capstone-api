package starter.Follow;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FollowUser {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method POST at api endpoints | FollowFollowUser")
    public String setMethodPost() {
        return this.endpoint + "/curent-user/user-followers";
    }

    @Step("Send method POST HTTP request | FollowFollowUser")
    public void sendMethodPost(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .post(this.setMethodPost() + "/" + id);
    }

    @Step("Receive valid HTTP response code 200 | FollowFollowUser")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message user succesfully followed | FollowFollowUser")
    public void receiveValidMessage() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data.title", equalTo(null)));
    }
}
