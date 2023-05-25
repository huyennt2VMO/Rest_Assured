package assured.com.data.restfulbooker;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDetailResponse {
    @JsonAlias({"ID", "Id", "id"})
    @JsonProperty("Id")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("profilepicture")
    private String profile_picture;

    @JsonProperty("location")
    private String location;

    @JsonProperty("createdat")
    private String create_at;

     private String password;
}
