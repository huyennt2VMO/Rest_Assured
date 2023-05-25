package assured.com.data.reqres;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AuthenticationRequest implements Serializable {
    private String email;
    private String password;
}
