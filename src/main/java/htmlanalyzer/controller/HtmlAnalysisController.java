package htmlanalyzer.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class HtmlAnalysisController {

    @GetMapping("/html/analysis")
    public String getHtmlAnalysis(@RequestParam String url) throws IOException {
        // TODO: Move to service:
        Document document = Jsoup.connect(url).get();
        List<Node> nodes = document.childNodes();

        for (Node node : nodes) {
            if (node instanceof DocumentType) {
                DocumentType documentType = (DocumentType)node;
                String htmlVersion = documentType.toString();
            }
        }

        // FIXME: Return type
        return "analysis returned";
    }

    // TODO : Add path to class level
    // TODO: Remove ?? Because we need a "get" form (changed already) -> TODO: Fix form submission and jsp in general
    @PostMapping("/html/analysis")
    public String postHtmlAnalysis(@ModelAttribute String url) {
        return "post method"; // FIXME: Needed??
    }
}
