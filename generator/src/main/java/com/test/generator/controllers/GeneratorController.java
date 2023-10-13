package com.test.generator.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.generator.services.GeneratorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @PostMapping("/token")
    public String generateToken(@RequestBody ArrayList<Integer> digits) {
        return generatorService.generateToken(digits);
    }
}
