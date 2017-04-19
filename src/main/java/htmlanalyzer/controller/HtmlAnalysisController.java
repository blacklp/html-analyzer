package htmlanalyzer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlAnalysisController {

    @RequestMapping("/html/analysis")
    public String getHtmlAnalysis(@RequestParam String url) {
        // FIXME: Return type
        return "analysis returned";
    }
}
