package kr.dboo.api.service;

import kr.dboo.api.payload.SavePostRequest;
import kr.dboo.api.repository.PostRepository;
import kr.dboo.api.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPostList() {
        return postRepository.findAll();
    }

    @Transactional
    public void savePost(SavePostRequest savePostRequest) {
        Post post = Post.builder()
                .title(savePostRequest.getTitle())
                .content(savePostRequest.getContent())
                .build();
        postRepository.findById(savePostRequest.getId())
                .ifPresent(p -> post.setId(savePostRequest.getId()));
        postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
