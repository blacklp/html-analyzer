package htmlanalyzer.controllers;

import htmlanalyzer.models.HtmlAnalysis;
import htmlanalyzer.models.URL;
import htmlanalyzer.services.HtmlAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class HtmlAnalysisController {

    @Autowired
    private HtmlAnalysisService htmlAnalysisService;

    @GetMapping("/html/analysis")
    public String getHtmlAnalysis(@ModelAttribute("url") URL url, final ModelMap model) throws IOException, URISyntaxException {
        HtmlAnalysis htmlAnalysis = htmlAnalysisService.getAnalysis(url.getUrl());

        model.addAttribute("url", url.getUrl());
        model.addAttribute("title", htmlAnalysis.getTitle());
        model.addAttribute("htmlVersion", htmlAnalysis.getHtmlVersion());
        model.addAttribute("numHeadings", htmlAnalysis.getNumHeadingsByLevel());
        model.addAttribute("numInternalLinks", htmlAnalysis.getNumInternalLinks());
        model.addAttribute("numExternalLinks", htmlAnalysis.getNumExternalLinks());
        model.addAttribute("containsLoginForm", htmlAnalysis.isContainsLoginForm());

        return "html-analysis";

    }
}
