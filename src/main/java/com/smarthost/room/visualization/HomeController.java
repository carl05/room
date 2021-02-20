package com.smarthost.room.visualization;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HomeController {

    @GetMapping("/")
    void hello(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

}

