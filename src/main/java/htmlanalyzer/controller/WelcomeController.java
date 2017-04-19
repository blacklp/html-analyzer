package htmlanalyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    /**
     *
     * @return The name of the view that will render the HTML content
     */
    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
}
