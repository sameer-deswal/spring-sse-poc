package ai.lumiq.spring.sse.spring_sse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SseController {

    @Autowired
    private SseService sseService;

    @GetMapping("/consumeEvents")
    private String consumeEvents() {
        sseService.consume();
        return "Started consuming";
    }
}
