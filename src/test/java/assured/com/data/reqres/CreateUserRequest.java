package assured.com.data.reqres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CreateUserRequest implements Serializable {

    private String name;
    private String email;
    private String password;

}
