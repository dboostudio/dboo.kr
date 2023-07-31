package kr.dboo.api.v1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String encodedPassword;
    @Lob
    private String comment;
    @CreatedDate
    private LocalDateTime createdAt;
}
