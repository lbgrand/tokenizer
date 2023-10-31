package com.test.generator.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.generator.services.GeneratorService;

@ExtendWith(MockitoExtension.class)
public class GeneratorControllerTest {

    @Mock
    private GeneratorService generatorService;

    @InjectMocks
    private GeneratorController generatorController;

    @Test
    public void testGenerateToken() {
        ArrayList<Integer> digits = new ArrayList<>(List.of(1, 2, 3));
        String expected = "123";
        when(generatorService.generateToken(digits)).thenReturn(expected);

        String token = generatorController.generateToken(digits);

        assertEquals(expected, token);
    }
}
