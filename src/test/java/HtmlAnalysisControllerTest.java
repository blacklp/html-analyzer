import htmlanalyzer.Application;
import htmlanalyzer.controller.HtmlAnalysisController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = Application.class)
public class HtmlAnalysisControllerTest {
    @Autowired
    private HtmlAnalysisController controller;

    @Test
    public void getHtmlAnalysis() throws IOException {
        String url = "https://arxiv.org/";
//        String url = "http://google.com";

        String htmlAnalysis = controller.getHtmlAnalysis(url);

        // TODO: Expect html version "-//W3C//DTD XHTML 1.0 Transitional//EN"

        // TODO: Maybe extract text after DTD, i.e. XHTML 1.0 and e.g. in case PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> then return HTML 4.01

        // TODO: Expect title "arXiv.org e-Print archive"
    }
}
