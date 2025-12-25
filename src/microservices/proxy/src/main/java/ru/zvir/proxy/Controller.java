package ru.zvir.proxy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/proxy")
public class Controller {

    @GetMapping(value = "/health")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Boolean>> getHealth() {
        return ResponseEntity.ok().body(Map.of("status", true));
    }
}
