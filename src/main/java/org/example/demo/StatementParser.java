package org.example.demo;

import java.util.List;

/**
 * 123+124
 *
 */
public class StatementParser {

    public Statement parse(String input) {
        List<Character> validOperators = List.of('+', '-', '*', '/');

        char[] chars = input.toCharArray();

        StringBuilder buffer = new StringBuilder();

        String first = null;
        Character operator = null;
        boolean operatorFound = false;

        int cur = 0;
        while (cur < chars.length) {
            if (chars[cur] == ' ') {
                cur++;
                continue;
            }
            if (validOperators.contains(chars[cur])) {
                operatorFound = true;
                operator = chars[cur];
                cur++;
                continue;
            }
            if (operatorFound) {
                first = buffer.toString();
                buffer.delete(0, buffer.length());
                operatorFound = false;
            }

            if (chars[cur] == ',') {
                buffer.append('.');
            } else {
                buffer.append(chars[cur]);
            }

            cur++;
        }

        Statement statement = new Statement();
        statement.first = Double.parseDouble(first);
        statement.second = Double.parseDouble(buffer.toString());
        statement.operator = String.valueOf(operator);
        return statement;
    }

    public static void main(String[] args) {

        StatementParser parser = new StatementParser();

        Statement statement = parser.parse("1,1  +  1.8");
        System.out.println(statement);

        CallCulytor callCulytor = new CallCulytor();
        double res = callCulytor.calculate(statement);
        System.out.println("res=" + res);
    }

}
