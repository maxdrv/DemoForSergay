package org.example.demo;

import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CallCulytor {

    double div(double a, double b) {
        if (b == 0) {
            throw new RuntimeException("Деление на ноль запрещено");
        }
        return a / b;
    }
    double sum(double a, double b) {
        return a + b;
    }
    double pow(double a, double b) {
        return Math.pow(a, b);
    }

    double sub(double a, double b) {
        return a - b;
    }

    double mult(double a, double b) {
        return a * b;
    }
    double divRem(double a, double b) {
        return a % b;
    }

    public Statement parse(String statement) {
        StringTokenizer st = new StringTokenizer(statement, " +-*/^%", true);
        double operand1 = Double.parseDouble(st.nextToken().trim());
        String operator = st.nextToken().trim();
        double operand2 = Double.parseDouble(st.nextToken().trim());

        Statement result = new Statement();
        result.first = operand1;
        result.second = operand2;
        result.operator = operator;
        return result;
    }

    public double calculate(Statement statement) {
        double result;
        switch (statement.operator) {
            case "/" -> result = div(statement.first, statement.second);
            case "+" -> result = sum(statement.first, statement.second);
            case "-" -> result = sub(statement.first, statement.second);
            case "*" -> result = mult(statement.first, statement.second);
            case "^" -> result = pow(statement.first, statement.second);
            case "%" -> result = divRem(statement.first, statement.second);
            default -> throw new RuntimeException("Неизвестный оператор: " + statement.operator);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String abc = scanner.nextLine();

            if (Objects.equals(abc, "exit")) {
                return;
            }

            CallCulytor callCulytor = new CallCulytor();
            Statement statement = callCulytor.parse(abc);
            double result;
            try {
                result = callCulytor.calculate(statement);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Введите заново");
                continue;
            }
            System.out.println(result);
        }
    }



}
