package com.smarthost.room.visualization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}
