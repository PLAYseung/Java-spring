package org.example.calculate;

public class DivisionOperator implements NewArithmaticOperator{
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber opperand1, PositiveNumber opperand2) {
//        if (opperand2.toInt()==0) {
//            throw new IllegalArgumentException("0으로 나눌수 없습니다");
//        }
        return opperand1.toInt()/opperand2.toInt();
    }
}
