package kr.dboo;

import kr.dboo.api.v1.entity.Comment;
import kr.dboo.api.v1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DbooController {

    private final CommentRepository commentRepository;

    @GetMapping
    public String home(Model model) {
        addDefaultModelAttributes(model);
        return "index";
    }

    @GetMapping("/post")
    public String post(Model model) {
        addDefaultModelAttributes(model);
        return "post";
    }

    @GetMapping("/visit")
    public String visit(Model model) {
        addDefaultModelAttributes(model);

        List<Comment> comments = commentRepository.findAll();
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
        String hostname = "";
        hostname = InetAddress.getLocalHost().getHostName();
        model.addAttribute("hostname", hostname);
    }

}
