package Test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springboot_restdoc.SpringBootRestDocApplication;
import springboot_restdoc.controller.HomeController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HomeController.class)
//@SpringBootTest(classes = HomeController.class)
@ContextConfiguration(classes = {SpringBootRestDocApplication.class})
@AutoConfigureRestDocs(outputDir = "src/main/resources/restdoc")
public class SpringBootRestDocApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDeafultfaultMessage() throws Exception {
        this.mockMvc.perform(get("/restdoc")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello zyh")))
                .andDo(document("home"));
    }
}
