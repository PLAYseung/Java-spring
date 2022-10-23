package org.example.calculate;

public interface NewArithmaticOperator {
    boolean supports(String operator);
    int calculate(PositiveNumber opperand1, PositiveNumber opperand2);
}
