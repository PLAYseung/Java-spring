package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmaticOperator> arithmeticOperators = List.of(new MultiplicationOperator(), new AddtionOperator(), new SubtractionOperator(),new DivisionOperator());

    public static int calculator(PositiveNumber operand1, String operator, PositiveNumber operand2) throws IllegalAccessException {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1,operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalAccessException("올바른 시칙연산이 아닙니다"));
    }
}
