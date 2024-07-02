package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        Calculator calculator = new Calculator();
        ExternalApiService externalApiService = new ExternalApiService();
        calculatorService = new CalculatorService(calculator, externalApiService);
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(3, calculatorService.subtract(5, 2));
    }

    @Test
    public void testConcatenateWithExternalData() throws IOException, InterruptedException {
        // Utilise une vraie requête HTTP
        String result = calculatorService.concatenateWithExternalData(2);
        System.out.println(result); // Affiche le résultat pour vérification
    }
}
