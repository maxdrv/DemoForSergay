package org.example.demo;

public class Statement {
    double first;
    double second;
    String operator;

    @Override
    public String toString() {
        return "Statement{" +
                "first=" + first +
                ", second=" + second +
                ", operator='" + operator + '\'' +
                '}';
    }
}
