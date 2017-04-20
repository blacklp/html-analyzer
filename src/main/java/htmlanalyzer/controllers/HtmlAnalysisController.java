package htmlanalyzer.controllers;

import htmlanalyzer.models.HtmlAnalysis;
import htmlanalyzer.services.HtmlAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class HtmlAnalysisController {

    @Autowired
    private HtmlAnalysisService htmlAnalysisService;

    @GetMapping("/html/analysis")
    public ResponseEntity<HtmlAnalysis> getHtmlAnalysis(@RequestParam String url) throws IOException {
        HtmlAnalysis htmlAnalysis = htmlAnalysisService.getAnalysis(url);
        return ResponseEntity.ok(htmlAnalysis);

        // TODO: error handling and validation ?
    }

    // TODO : Add path to class level
    // TODO: Remove ?? Because we need a "get" form (changed already) -> TODO: Fix form submission and jsp in general
    @PostMapping("/html/analysis")
    public String postHtmlAnalysis(@ModelAttribute String url) {
        return "post method"; // FIXME: Needed??
    }
}
