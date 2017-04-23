package htmlanalyzer.services;

import htmlanalyzer.models.HtmlAnalysis;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class HtmlAnalysisService {
    public HtmlAnalysis getAnalysis(String url) throws IOException, URISyntaxException { // TODO: Try-catch ??
        Document document = Jsoup.connect(url).get();
        String title = document.title();

        HtmlAnalysis htmlAnalysis = new HtmlAnalysis(title);

        String htmlVersion = extractHtmlVersion(document);
        htmlAnalysis.setHtmlVersion(htmlVersion);

        Elements links = document.select("a[href]");
        URI uri = new URI(url);
        String host = uri.getHost();

        for (Element link : links) {
            String href = link.attr("href");
            URI hrefUri = new URI(href);
            boolean isInternal = !hrefUri.isAbsolute() || href.contains(host);
            if (isInternal) {
                htmlAnalysis.increaseInternalLinkCount();
            } else {
                htmlAnalysis.increaseExternalLinkCount();
            }
        }

        for (int headingLevel = 1; headingLevel <= 6; headingLevel++) {
            Elements headings = document.select("h" + headingLevel);
            htmlAnalysis.setHeadingCount(headingLevel, headings.size());
        }

        boolean containsLogin = extractContainsLoginForm(document);
        htmlAnalysis.setContainsLoginForm(containsLogin);

        return htmlAnalysis;
    }

    private boolean extractContainsLoginForm(Document document) {
        Elements passwordInputs = document.select("input[type=password]");
        return !passwordInputs.isEmpty();
    }

    private String extractHtmlVersion(Document document) {
        List<Node> nodes = document.childNodes();

        for (Node node : nodes) {
            if (node instanceof DocumentType) {
                DocumentType documentType = (DocumentType)node;
                String publicId = documentType.attr("publicid");
                return publicId.equals("") ? "HTML5" : publicId;
            }
        }
        return "";
    }
}
