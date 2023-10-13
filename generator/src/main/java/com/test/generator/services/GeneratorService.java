package com.test.generator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    
    public String generateToken(ArrayList<Integer> digits) {
        ArrayList<Integer> allowedDigits;
        if (digits == null || digits.isEmpty()) {
            allowedDigits = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        } else {
            validateDigits(digits);
            allowedDigits = digits;
        }

        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, allowedDigits.size());
                token.append(allowedDigits.get(randomNum));
            }
            if (i < 3) {
                token.append("-");
            }
        }

        return token.toString();
    }

    private void validateDigits(ArrayList<Integer> digits) {
        for (Integer digit : digits) {
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("Digits must be between 0 and 9.");
            }
        }
    }
}
