package com.smarthost.room;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;
import com.smarthost.room.visualization.HomeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
    @Autowired
    private HomeController homeController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void contextLoads() throws Exception {
        assertThat(homeController).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/")).andExpect(status().isFound())
                ;
    }

}