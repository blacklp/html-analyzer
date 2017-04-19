import htmlanalyzer.controller.HtmlAnalysisController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest
public class HtmlAnalysisControllerTest {
    @Autowired
    private HtmlAnalysisController controller;

    @Test
    public void getHtmlAnalysis() {
        String url = "http://google.com";

        String htmlAnalysis = controller.getHtmlAnalysis(url);
    }
}
