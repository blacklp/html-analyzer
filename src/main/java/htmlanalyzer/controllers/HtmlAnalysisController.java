package htmlanalyzer.controllers;

import htmlanalyzer.models.HtmlAnalysis;
import htmlanalyzer.services.HtmlAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HtmlAnalysisController {

    @Autowired
    private HtmlAnalysisService htmlAnalysisService;

    @GetMapping("/html/analysis")
    public ResponseEntity<HtmlAnalysis> getHtmlAnalysis(@RequestParam String url) throws IOException {
        HtmlAnalysis htmlAnalysis = htmlAnalysisService.getAnalysis(url);
        return ResponseEntity.ok(htmlAnalysis);
    }
}
