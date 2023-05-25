package assured.com.data.restfulbooker;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class CreateUserResponse {
    //    "Id": 233723,
//            "Name": "huyennt",
//            "Email": "huyennt@gmail.com",
//            "Token": "fb2a1003-6c0c-4a19-b5ee-7e727e80b77a"
    @JsonAlias({"ID", "Id", "id"})
    @JsonProperty("Id")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Token")
    private String token;

}
