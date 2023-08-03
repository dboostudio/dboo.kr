package kr.dboo.api.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SavePostRequest {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    private String content;
}
