package springboot_restdoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/restdoc")
    public Map<String, Object> greeting() {
        return  Collections.singletonMap("message", "hello zyh");
    }
}
