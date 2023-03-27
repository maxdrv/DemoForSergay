package org.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.StringTokenizer;

public class StringTokenizerDemo {

    @Test
    void test() {
        String input = "display asdfq234";

        StringTokenizer tokenizer = new StringTokenizer(input, " ");

        if (tokenizer.hasMoreTokens()) {
            String command = tokenizer.nextToken();

            if (Objects.equals("display", command)) {

                if (tokenizer.hasMoreTokens()) {
                    String parameter = tokenizer.nextToken();

                    if (Objects.equals(parameter, "datetime")) {
                        System.out.println("1. 2023-01-01 some text");
                    } else {
                        System.out.println("unexpected parameter");
                    }

                } else {
                    System.out.println("1. some text");
                }

            }

        } else {
            System.out.println("error");
        }
    }

}
