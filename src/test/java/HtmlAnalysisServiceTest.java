import htmlanalyzer.Application;
import htmlanalyzer.models.HtmlAnalysis;
import htmlanalyzer.services.HtmlAnalysisService;
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
    public void postHtmlAnalysisForArxiv() throws IOException, URISyntaxException {
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

        Assertions.assertThat(htmlAnalysis.getNumExternalLinks()).isEqualTo(9);
        Assertions.assertThat(htmlAnalysis.getNumInternalLinks()).isEqualTo(238);

        Assertions.assertThat(htmlAnalysis.isContainsLoginForm()).isFalse();
    }

    @Test
    public void postHtmlAnalysisForGoogle() throws IOException, URISyntaxException {
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

        Assertions.assertThat(htmlAnalysis.getNumExternalLinks()).isEqualTo(7);
        Assertions.assertThat(htmlAnalysis.getNumInternalLinks()).isEqualTo(13);

        Assertions.assertThat(htmlAnalysis.isContainsLoginForm()).isFalse();
    }

    @Test
    public void postHtmlAnalysisForGitHubLogin() throws IOException, URISyntaxException {
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
}
