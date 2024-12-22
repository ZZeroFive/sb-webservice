package ml.sb.ws.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demoController")
@Slf4j
public class DemoController {

    @RequestMapping("/{name}/hello")
    @GetMapping
    public String sayHello(@PathVariable(name = "name") String name) {
        log.info("[sayHello] {}", name);
        return String.format("[sayHello] %s", name);
    }
}
