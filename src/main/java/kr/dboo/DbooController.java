package kr.dboo;

import kr.dboo.api.v1.entity.Comment;
import kr.dboo.api.v1.entity.Post;
import kr.dboo.api.v1.repository.CommentRepository;
import kr.dboo.api.v1.service.CommentService;
import kr.dboo.api.v1.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.InetAddress;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DbooController {

    private final CommentService commentService;
    private final PostService postService;

    @GetMapping
    public String home(Model model) {
        addDefaultModelAttributes(model);
        return "index";
    }

    @GetMapping("/post")
    public String post(Model model) {
        addDefaultModelAttributes(model);
        List<Post> posts = postService.getAllPostList();
        model.addAttribute("posts", posts);
        return "post";
    }

    @GetMapping("/post/{id}")
    public String postDetail(
            Model model,
            @PathVariable Long id
    ) {
        addDefaultModelAttributes(model);
        System.out.println("detail-page with" + id);
        Post postById = postService.getPostById(id);
        model.addAttribute("title", postById.getTitle());
        model.addAttribute("content", postById.getContent());
        return "post-detail";
    }

    @GetMapping("/visit")
    public String visit(Model model) {
        addDefaultModelAttributes(model);

        List<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "visit";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        addDefaultModelAttributes(model);
        return "admin";
    }

    @SneakyThrows
    private static void addDefaultModelAttributes(Model model) {
        model.addAttribute("hostname", InetAddress.getLocalHost().getHostName());
    }

}
