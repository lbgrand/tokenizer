package com.test.validator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.validator.services.ValidatorService;

@RestController
public class ValidatorController {

    @Autowired
    private ValidatorService validatorService;

    @GetMapping("/validate/{token}")
    public boolean validateToken(@PathVariable String token) {
        return validatorService.validateTokenLuhnAlgorithm(token);
    }
}
