package htmlanalyzer.controllers;

import htmlanalyzer.models.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    /**
     *
     * @return The name of the view that will render the HTML content
     */
    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("url", new URL(""));
        return "welcome";
    }
}
