package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CalculatorServiceTest {

    @Mock
    private Calculator calculator;

    @Mock
    private ExternalApiService externalApiService;

    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        calculatorService = new CalculatorService(calculator, externalApiService);
    }

    @Test
    public void testAdd() {
        when(calculator.add(2, 3)).thenReturn(5);
        assertEquals(5, calculatorService.add(2, 3));
        verify(calculator).add(2, 3);
    }

    @Test
    public void testSubtract() {
        when(calculator.subtract(5, 2)).thenReturn(3);
        assertEquals(3, calculatorService.subtract(5, 2));
        verify(calculator).subtract(5, 2);
    }

    @Test
    public void testConcatenateWithExternalData() throws IOException, InterruptedException {
        when(externalApiService.fetchData()).thenReturn("test title");
        assertEquals("Result: 2 test title", calculatorService.concatenateWithExternalData(2));
        verify(externalApiService).fetchData();
    }
}
