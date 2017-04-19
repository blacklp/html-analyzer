package htmlanalyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

//    @Value("${application.message:Hello World}")
//    private String message = "Hello World";

    /**
     *
     * @return The name of the view that will render the HTML content
     */
    @GetMapping("/")
    public String welcome(/*Map<String, Object> model*/) {
//        model.put("time", new Date());
//        model.put("message", this.message);
        return "welcome";
    }

//    @RequestMapping("/foo")
//    public String foo(Map<String, Object> model) {
//        throw new RuntimeException("Foo");
//    }
}
