package starter.Follow;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FollowCommunity {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method POST at api endpoints | FollowFollowCommunity")
    public String setMethodPost() {
        return this.endpoint + "/community-followers";
    }

    @Step("Send method POST HTTP request | FollowFollowCommunity")
    public void sendMethodPost(String token, Integer id) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .post(this.setMethodPost() + "/" + id);
    }

    @Step("Receive valid HTTP response code 200 | FollowFollowCommunity")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid message community succesfully followed | FollowFollowCommunity")
    public void receiveValidMessage() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data.title", equalTo(null)));
    }
}
