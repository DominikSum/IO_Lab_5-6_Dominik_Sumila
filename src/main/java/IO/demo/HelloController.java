package IO.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Czołem Panie Kapitanie!!! System CI/CD działa poprawnie.";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Serwer powstał i działa <3";
    }

    @GetMapping("/api/status")
    public Map<String, Object> status() {
        Map<String, Object> response = new HashMap<>();
        response.put("environment", "Production (Render)");
        response.put("serverTime", LocalDateTime.now().toString());
        response.put("message", "Aplikacja przetwarza dane w sposób dynamiczny");
        response.put("status", "UP");
        return response;
    }
}
