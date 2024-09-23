package ai.lumiq.spring.sse.spring_sse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class SseService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public void consume() {
        webClientBuilder.baseUrl("http://localhost:3000/slow-process").build()
                .get()
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(Map.class)
                .subscribe((s) -> {
                    System.out.println(s);
                });
    }
}
