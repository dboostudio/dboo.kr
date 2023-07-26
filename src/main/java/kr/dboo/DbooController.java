package kr.dboo;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;
import java.util.List;

@Controller
public class DbooController {

    @GetMapping("/resume")
    public String resume(Model model){
        addDefaultModelAttributes(model);
        return "resume";
    }

    @GetMapping("/post")
    public String post(Model model) {
        addDefaultModelAttributes(model);
        return "post";
    }

    @GetMapping("/visit")
    public String visit(Model model) {
        addDefaultModelAttributes(model);
        Comment comment1 = Comment.builder()
                .name("부대환")
                .comment("잘보고 갑니다~")
                .build();
        Comment comment2 = Comment.builder()
                .name("부대환")
                .comment("잘보고 갑니다~")
                .build();
        List<Comment> comments = List.of(comment1, comment2);
        model.addAttribute("comments", comments);
        return "visit";
    }

    @GetMapping
    public String home(Model model) {
        addDefaultModelAttributes(model);
        return "index";
    }

    @SneakyThrows
    private static void addDefaultModelAttributes(Model model) {
        String hostname = "";
        hostname = InetAddress.getLocalHost().getHostName();
        model.addAttribute("hostname", hostname);
    }

}
