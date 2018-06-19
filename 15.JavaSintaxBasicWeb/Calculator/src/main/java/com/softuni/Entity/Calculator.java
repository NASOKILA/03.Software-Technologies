package com.softuni.Entity;

public class Calculator {

    private double leftOperand;
    private double rightoperand;
    private String operator;

    public Calculator(double leftOperand, double rightoperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightoperand = rightoperand;
        this.operator = operator;
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightoperand() {
        return rightoperand;
    }

    public void setRightoperand(double rightoperand) {
        this.rightoperand = rightoperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    public double calculateResult(){

        double result;
        switch (this.operator)
        {
            case "+":
                result = this.getLeftOperand() + this.getRightoperand();
                break;
            case "-":
                result = this.getLeftOperand() - this.getRightoperand();
                break;
            case "*":
                result = this.getLeftOperand() * this.getRightoperand();
                break;
            case "/":
                result = this.getLeftOperand() / this.getRightoperand();
                break;
            default: // KATO DEFAULT MU DAVAME 0
                result = 0;
        }

        return result;
    }


}


