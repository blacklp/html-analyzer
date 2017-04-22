package htmlanalyzer.controllers;

import htmlanalyzer.models.HtmlAnalysis;
import htmlanalyzer.services.HtmlAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HtmlAnalysisController {

    @Autowired
    private HtmlAnalysisService htmlAnalysisService;

    @GetMapping("/html/analysis")
    public String getHtmlAnalysis(@RequestParam String url) throws IOException {
        HtmlAnalysis htmlAnalysis = htmlAnalysisService.getAnalysis(url);
        return "<html>" +
                    "<head><title>HTML Analysis Result</title></head>" +
                    "<body>" +
                        "<h1>HTML Analysis for Page: " + url + "</h1><br/><br/>" +
                        "<table>" +
                            "<tr>" +
                                "<th>HTML Version</th>" +
                                "<th>Page Title</th>" +
                                "<th>Number of headings H1</th>" +
                                "<th>Number of headings H2</th>" +
                                "<th>Number of headings H3</th>" +
                                "<th>Number of headings H4</th>" +
                                "<th>Number of headings H5</th>" +
                                "<th>Number of headings H6</th>" +
                                "<th>Number of Internal Links</th>" +
                                "<th>Number of External Links</th>" +
                                "<th>Contains Login Form</th>" +
                            "</tr>" +
                            "<tr>" +
                                "<td>" + htmlAnalysis.getHtmlVersion() + "</td>" +
                                "<td>" + htmlAnalysis.getTitle() + "</td>" +
                                "<td>" + htmlAnalysis.getNumHeadingsByLevel()[0] + "</td>" +
                                "<td>" + htmlAnalysis.getNumHeadingsByLevel()[1] + "</td>" +
                                "<td>" + htmlAnalysis.getNumHeadingsByLevel()[2] + "</td>" +
                                "<td>" + htmlAnalysis.getNumHeadingsByLevel()[3] + "</td>" +
                                "<td>" + htmlAnalysis.getNumHeadingsByLevel()[4] + "</td>" +
                                "<td>" + htmlAnalysis.getNumHeadingsByLevel()[5] + "</td>" +
                                "<td>" + htmlAnalysis.getNumInternalLinks() + "</td>" +
                                "<td>" + htmlAnalysis.getNumExternalLinks() + "</td>" +
                                "<td>" + htmlAnalysis.isContainsLoginForm() + "</td>" +
                            "</tr>" +
                        "</table>" +
                    "</body>" +
                "</html>";
    }
}
