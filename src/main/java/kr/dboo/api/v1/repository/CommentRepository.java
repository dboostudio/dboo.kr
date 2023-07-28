package kr.dboo.api.v1.repository;

import kr.dboo.api.v1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
