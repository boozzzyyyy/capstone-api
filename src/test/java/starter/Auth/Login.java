package starter.Auth;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

public class Login {
    public static String endpoint = "http://108.136.47.34:8080/api/v1";

    public String loginGetToken(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email","salsabillanugraha10@mhs.itenas.ac.id");
//        requestBody.put("email","admin@gmail.com");
        requestBody.put("password","123456");
        return SerenityRest.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(this.endpoint + "/login")
                .getBody()
                .jsonPath()
                .get("Data.token");
    }
}
