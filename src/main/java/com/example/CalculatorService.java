package com.example;
import java.io.IOException;

public class CalculatorService {
    private final Calculator calculator;
    private final ExternalApiService externalApiService;

    public CalculatorService(Calculator calculator, ExternalApiService externalApiService) {
        this.calculator = calculator;
        this.externalApiService = externalApiService;
    }

    public int add(int a, int b) {
        return calculator.add(a, b);
    }

    public int subtract(int a, int b) {
        return calculator.subtract(a, b);
    }


    public String concatenateWithExternalData(int a) throws IOException, InterruptedException {
        String externalData = externalApiService.fetchData();
        return "Result: " + a + " " + externalData;
    }
}
