package htmlanalyzer.controllers;

import htmlanalyzer.models.HtmlAnalysis;
import htmlanalyzer.services.HtmlAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class HtmlAnalysisController {

    @Autowired
    private HtmlAnalysisService htmlAnalysisService;

    @GetMapping("/html/analysis")
    public String getHtmlAnalysis(@RequestParam String url) throws IOException, URISyntaxException {
        HtmlAnalysis htmlAnalysis = htmlAnalysisService.getAnalysis(url);
        StringBuilder html = new StringBuilder();
        html.append(
            "<html>" +
                "<head><title>HTML Analysis Result</title></head>" +
                    "<body>" +
                        "<h1>HTML Analysis for Page: " + url + "</h1><br/><br/>" +
                        "<table border='1'>" +
                            "<tr>" + "<th>HTML Version</th>" + "<th>Page Title</th>");

        int[] headings = htmlAnalysis.getNumHeadingsByLevel();

        for (int i = 0; i < headings.length; i++) {
            html.append("<th>Num H" + (i + 1) + "</th>");
        }

        html.append(
                "<th>Num Internal Links</th>" +
                "<th>Num External Links</th>" +
                "<th>Has Login</th>" +
                "</tr>" +
                "<tr>" +
                "<td>" + htmlAnalysis.getHtmlVersion() + "</td>" +
                "<td>" + htmlAnalysis.getTitle() + "</td>");

        for (int i = 0; i < headings.length; i++) {
            html.append("<td>" + htmlAnalysis.getNumHeadingsByLevel()[i] + "</td>");
        }

        html.append(
                "<td>" + htmlAnalysis.getNumInternalLinks() + "</td>" +
                "<td>" + htmlAnalysis.getNumExternalLinks() + "</td>" +
                "<td>" + htmlAnalysis.isContainsLoginForm() + "</td>");
        html.append("</tr>" + "</table>" + "</body>" + "</html>");

        return html.toString();

    }
}
