package kr.dboo.api.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestPayload {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
