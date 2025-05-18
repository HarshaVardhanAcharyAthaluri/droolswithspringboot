package com.harshatrainings.droolswithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ValidationController {

    @Autowired
    DroolsService droolsService;

    @PostMapping("/validate")
    public String validate(@RequestBody Map<String, Object> jsonMap) {
        return droolsService.validatePersons(jsonMap);
    }
}
