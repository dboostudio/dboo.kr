package kr.dboo.api.service;

import kr.dboo.api.payload.CreatePostRequest;
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

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void savePost(SavePostRequest savePostRequest) {
        Post post = postRepository.findById(savePostRequest.getId())
                .orElseThrow(RuntimeException::new);
        post.setTitle(savePostRequest.getTitle());
        post.setContent(savePostRequest.getContent());
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = Post.builder()
                .title(createPostRequest.getTitle())
                .content(createPostRequest.getContent())
                .build();
        postRepository.save(post);
    }
}
