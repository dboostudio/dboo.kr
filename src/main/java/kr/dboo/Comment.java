package kr.dboo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Comment {
    private String name;
    private String comment;
}
