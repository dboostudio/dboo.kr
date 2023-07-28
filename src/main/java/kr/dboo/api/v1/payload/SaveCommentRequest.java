package kr.dboo.api.v1.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveCommentRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String comment;
}
