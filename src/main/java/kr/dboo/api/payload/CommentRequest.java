package kr.dboo.api.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 20, message = "이름은 20자 이하로 입력해주세요.")
    private String name;
    @NotBlank(message = "이메일을 입력해주세요.")
    @Size(max = 50, message = "이메일은 50자 이하로 입력해주세요.")
    private String email;
    @NotBlank(message = "코멘트를 입력해주세요.")
    @Size(max = 1000, message = "코멘트는 1000자 이하로 입력해주세요.")
    private String comment;
}
