import htmlanalyzer.Application;
import htmlanalyzer.controllers.HtmlAnalysisController;
import htmlanalyzer.models.HtmlAnalysis;
import htmlanalyzer.services.HtmlAnalysisService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = { Application.class, HtmlAnalysisService.class })
public class HtmlAnalysisControllerTest {
    @Autowired
    private HtmlAnalysisController controller;

    @Test
    public void getHtmlAnalysisForArxiv() throws IOException {
        String url = "https://arxiv.org/";

        ResponseEntity<HtmlAnalysis> response = controller.getHtmlAnalysis(url);
        HtmlAnalysis htmlAnalysis = response.getBody();

        Assertions.assertThat(htmlAnalysis.getHtmlVersion()).isEqualTo("-//W3C//DTD XHTML 1.0 Transitional//EN");
        // TODO: Maybe extract text after DTD, i.e. XHTML 1.0 and e.g. in case PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> then return HTML 4.01

        Assertions.assertThat(htmlAnalysis.getTitle()).isEqualTo("arXiv.org e-Print archive");
    }

    @Test
    public void getHtmlAnalysisForGoogle() throws IOException {
        String url = "http://google.com";

        ResponseEntity<HtmlAnalysis> response = controller.getHtmlAnalysis(url);
        HtmlAnalysis htmlAnalysis = response.getBody();

        Assertions.assertThat(htmlAnalysis.getHtmlVersion()).isEqualTo("HTML5");
        Assertions.assertThat(htmlAnalysis.getTitle()).isEqualTo("Google");
    }
}
