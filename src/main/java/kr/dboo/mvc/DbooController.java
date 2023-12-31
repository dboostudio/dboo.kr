package kr.dboo.mvc;

import kr.dboo.api.entity.Comment;
import kr.dboo.api.entity.Post;
import kr.dboo.api.service.CommentService;
import kr.dboo.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

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
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post-detail";
    }

    @GetMapping("/post/create")
    public String postCreate(
            Model model
    ) {
        addDefaultModelAttributes(model);
        return "post-create";
    }

    @GetMapping("/post/edit/{id}")
    public String postEdit(
            Model model,
            @PathVariable Long id
    ) {
        addDefaultModelAttributes(model);
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post-edit";
    }

    @GetMapping("/visit")
    public String visit(Model model) {
        addDefaultModelAttributes(model);
        List<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "visit";
    }

    @GetMapping("/admin")
    public ModelAndView admin(Model model) {
        addDefaultModelAttributes(model);
        return new ModelAndView("admin");
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        addDefaultModelAttributes(model);
        return "sign-up";
    }

    @GetMapping("/login")
    public String login(Model model) {
        addDefaultModelAttributes(model);
        return "login";
    }

    @SneakyThrows
    private static void addDefaultModelAttributes(Model model) {
        model.addAttribute("hostname", InetAddress.getLocalHost().getHostName());
    }

}
