package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @PostMapping("/calculate")
    public ApiResponse calculate(@RequestBody CalculatorRequest request) {
        String expression = request.getExpression();

        try {
            double result = evaluateExpression(expression);
            return new ApiResponse(result);
        } catch (Exception e) {
            return new ApiResponse("Invalid expression");
        }
    }

    private double evaluateExpression(String expression) {
        // You can implement a more robust expression evaluation logic here if needed.
        return Double.parseDouble(expression);
    }
}
