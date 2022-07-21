package starter.Thread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    @Step("Set method GET at api endpoints | ThreadGet")
    public String setMethodGet() {
        return this.endpoint + "/threads";
    }

    @Step("Send method GET HTTP request | ThreadGet")
    public void sendMethodGet(String token, Integer limit, String keyword, Boolean trending, String community, String forYou) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .get(this.setMethodGet() + "?limit=" + limit + "&keyword=" + keyword + "&trending=" + trending + "&community=" + community + "&forYou=" + forYou);
    }

    @Step("Receive valid HTTP response code 200 | ThreadGet")
    public void receiveValidHTTP() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Receive valid data thread succesfully | ThreadGet")
    public void receiveValidData() {
        restAssuredThat(response -> response.body("Meta.message", equalTo("OK")));
        restAssuredThat(response -> response.body("Data[0].ID", equalTo(1)));
    }
}
