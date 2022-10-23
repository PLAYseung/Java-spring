package org.example.calculate;

public class SubtractionOperator implements NewArithmaticOperator{
    @Override
    public boolean supports(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber opperand1, PositiveNumber opperand2) {
        return opperand1.toInt()-opperand2.toInt();
    }
}
