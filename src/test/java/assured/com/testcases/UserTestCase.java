package assured.com.testcases;

import assured.com.data.reqres.AuthenticationRequest;
import assured.com.data.reqres.CreateUserRequest;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserTestCase extends SetupConfig {
    //    private UserDetailResponse response = new UserDetailResponse();
    final Map<String, Object> responseMap = new HashMap<>();

    @Test
    public void createUser() {
        CreateUserRequest userDataCreate = new CreateUserRequest("huyennt2",
                UUID.randomUUID() + "huyennt2@gxxxmail.com",
                "huyen123@");

        given().body(userDataCreate).contentType(ContentType.JSON)
                .when()
                .post("/api/authaccount/registration")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("data.Name", equalTo(userDataCreate.getName()))
                .body("message", equalTo("success"));
        responseMap.put("email", userDataCreate.getEmail());
        responseMap.put("password", userDataCreate.getPassword());
    }

    @Test
    public void authentication() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(String.valueOf(responseMap.get("email")),
                String.valueOf(responseMap.get("password")));
        final String response = given()
                .body(authenticationRequest)
                .when()
                .post("/api/authaccount/login")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("data.Id", notNullValue())
                .and()
                .body("data.Token", notNullValue())
                .and()
                .extract()
                .response()
                .asString();
        final JSONObject responseObject = new JSONObject(response);
        final JSONObject data = responseObject.getJSONObject("data");
        responseMap.put("id", data.getInt("Id"));
        responseMap.put("token", data.getString("Token"));
        System.out.println(responseMap + "xxxxxxx");
    }

    @Test()
    public void getDetailUser() {
        given().header("Authorization", "Bearer "+ responseMap.get("token")).when().get("/api/users/" + String.valueOf(responseMap.get("id")))
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("id", equalTo(responseMap.get("id")));
    }
}
