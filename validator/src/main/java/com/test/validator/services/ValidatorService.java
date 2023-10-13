package com.test.validator.services;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    public boolean validateTokenLuhnAlgorithm(String token) {
        if (token == null || !isValidTokenFormat(token)) {
            throw new IllegalArgumentException("Invalid token format. Should be e.g. 1234-5678-9012-3456.");
        }

        String digitsToken = token.replace("-", "");
        int checkDigit = Character.getNumericValue(digitsToken.charAt(digitsToken.length() - 1));
        int computedCheckDigit = computeCheckDigit(digitsToken.substring(0, digitsToken.length() - 1));

        return checkDigit == computedCheckDigit;
    }

    private int computeCheckDigit(String token) {
        int checkDigitSum = 0;
        for (int i = 0; i < token.length(); i++) {
            int digit = Character.getNumericValue(token.charAt(i));
            if (i % 2 == 0) {
                checkDigitSum += digitsSum(digit * 2);
            } else {
                checkDigitSum += digit;
            }
        }

        return 10 - (checkDigitSum % 10);
    }

    private int digitsSum(int number) {
        return number % 10 + number / 10;
    }

    private boolean isValidTokenFormat(String token) {
        String pattern = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";
        return token.matches(pattern);
    }
}
