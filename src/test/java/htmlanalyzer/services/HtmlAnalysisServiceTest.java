package htmlanalyzer.services;

import htmlanalyzer.Application;
import htmlanalyzer.models.HtmlAnalysis;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = { Application.class, HtmlAnalysisService.class })
public class HtmlAnalysisServiceTest {
    @Autowired
    private HtmlAnalysisService service;

    @Test
    public void getAnalysisForArxiv() throws IOException, URISyntaxException {
        String url = "https://arxiv.org/";

        HtmlAnalysis htmlAnalysis = service.getAnalysis(url);

        Assertions.assertThat(htmlAnalysis.getHtmlVersion()).isEqualTo("XHTML 1.0 Transitional");

        Assertions.assertThat(htmlAnalysis.getTitle()).isEqualTo("arXiv.org e-Print archive");

        int[] numHeadings = htmlAnalysis.getNumHeadingsByLevel();
        Assertions.assertThat(numHeadings[0]).isEqualTo(1); // H1
        Assertions.assertThat(numHeadings[1]).isEqualTo(7); // H2
        Assertions.assertThat(numHeadings[2]).isEqualTo(0); // H3
        Assertions.assertThat(numHeadings[3]).isEqualTo(0); // H4
        Assertions.assertThat(numHeadings[4]).isEqualTo(0); // H5
        Assertions.assertThat(numHeadings[5]).isEqualTo(0); // H6

        Assertions.assertThat(htmlAnalysis.getNumExternalLinks()).isEqualTo(0);
        Assertions.assertThat(htmlAnalysis.getNumInternalLinks()).isEqualTo(247);

        Assertions.assertThat(htmlAnalysis.isContainsLoginForm()).isFalse();
    }

    @Test
    public void getAnalysisForGoogle() throws IOException, URISyntaxException {
        String url = "http://google.com";

        HtmlAnalysis htmlAnalysis= service.getAnalysis(url);

        Assertions.assertThat(htmlAnalysis.getHtmlVersion()).isEqualTo("HTML 5");
        Assertions.assertThat(htmlAnalysis.getTitle()).isEqualTo("Google");

        int[] numHeadings = htmlAnalysis.getNumHeadingsByLevel();
        Assertions.assertThat(numHeadings[0]).isEqualTo(0); // H1
        Assertions.assertThat(numHeadings[1]).isEqualTo(0); // H2
        Assertions.assertThat(numHeadings[2]).isEqualTo(0); // H3
        Assertions.assertThat(numHeadings[3]).isEqualTo(0); // H4
        Assertions.assertThat(numHeadings[4]).isEqualTo(0); // H5
        Assertions.assertThat(numHeadings[5]).isEqualTo(0); // H6

        Assertions.assertThat(htmlAnalysis.getNumExternalLinks()).isEqualTo(0);
        Assertions.assertThat(htmlAnalysis.getNumInternalLinks()).isEqualTo(20);

        Assertions.assertThat(htmlAnalysis.isContainsLoginForm()).isFalse();
    }

    @Test
    public void getAnalysisForGitHubLogin() throws IOException, URISyntaxException {
        String url = "https://github.com/login";

        HtmlAnalysis htmlAnalysis= service.getAnalysis(url);

        Assertions.assertThat(htmlAnalysis.getHtmlVersion()).isEqualTo("HTML 5");
        Assertions.assertThat(htmlAnalysis.getTitle()).isEqualTo("Sign in to GitHub · GitHub");

        int[] numHeadings = htmlAnalysis.getNumHeadingsByLevel();
        Assertions.assertThat(numHeadings[0]).isEqualTo(1); // H1
        Assertions.assertThat(numHeadings[1]).isEqualTo(0); // H2
        Assertions.assertThat(numHeadings[2]).isEqualTo(0); // H3
        Assertions.assertThat(numHeadings[3]).isEqualTo(0); // H4
        Assertions.assertThat(numHeadings[4]).isEqualTo(0); // H5
        Assertions.assertThat(numHeadings[5]).isEqualTo(0); // H6

        Assertions.assertThat(htmlAnalysis.getNumExternalLinks()).isEqualTo(0);
        Assertions.assertThat(htmlAnalysis.getNumInternalLinks()).isEqualTo(10);

        Assertions.assertThat(htmlAnalysis.isContainsLoginForm()).isTrue();
    }

    @Test
    public void getAnalysisForW3Html4Links() throws IOException, URISyntaxException {
        String url = "https://www.w3.org/TR/html4/struct/links.html";

        HtmlAnalysis htmlAnalysis= service.getAnalysis(url);

        Assertions.assertThat(htmlAnalysis.getHtmlVersion()).isEqualTo("HTML 4.01 Transitional");
        Assertions.assertThat(htmlAnalysis.getTitle()).isEqualTo("Links in HTML documents");

        int[] numHeadings = htmlAnalysis.getNumHeadingsByLevel();
        Assertions.assertThat(numHeadings[0]).isEqualTo(1); // H1
        Assertions.assertThat(numHeadings[1]).isEqualTo(4); // H2
        Assertions.assertThat(numHeadings[2]).isEqualTo(13); // H3
        Assertions.assertThat(numHeadings[3]).isEqualTo(0); // H4
        Assertions.assertThat(numHeadings[4]).isEqualTo(0); // H5
        Assertions.assertThat(numHeadings[5]).isEqualTo(0); // H6

        Assertions.assertThat(htmlAnalysis.getNumExternalLinks()).isEqualTo(0);
        Assertions.assertThat(htmlAnalysis.getNumInternalLinks()).isEqualTo(316);

        Assertions.assertThat(htmlAnalysis.isContainsLoginForm()).isFalse();
    }

    @Test
    public void getAnalysisForSpiegelLogin() throws IOException, URISyntaxException {
        String url = "https://www.spiegel.de/meinspiegel/login.html";

        HtmlAnalysis htmlAnalysis= service.getAnalysis(url);

        Assertions.assertThat(htmlAnalysis.getHtmlVersion()).isEqualTo("HTML 4.01 Transitional");
        Assertions.assertThat(htmlAnalysis.getTitle()).isEqualTo("Mein SPIEGEL - SPIEGEL ONLINE");

        int[] numHeadings = htmlAnalysis.getNumHeadingsByLevel();
        Assertions.assertThat(numHeadings[0]).isEqualTo(1); // H1
        Assertions.assertThat(numHeadings[1]).isEqualTo(1); // H2
        Assertions.assertThat(numHeadings[2]).isEqualTo(0); // H3
        Assertions.assertThat(numHeadings[3]).isEqualTo(2); // H4
        Assertions.assertThat(numHeadings[4]).isEqualTo(5); // H5
        Assertions.assertThat(numHeadings[5]).isEqualTo(0); // H6

        Assertions.assertThat(htmlAnalysis.getNumExternalLinks()).isEqualTo(0);
        Assertions.assertThat(htmlAnalysis.getNumInternalLinks()).isEqualTo(273);

        Assertions.assertThat(htmlAnalysis.isContainsLoginForm()).isTrue();
    }
}
