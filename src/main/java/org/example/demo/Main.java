package org.example.demo;

public class Main {

    public static String[] delete(String[] original, int index) {
        if (index < 0 || index > original.length - 1) {
            return original;
        }
        String[] result = new String[original.length - 1];
        for (int i = 0; i < original.length; i++) {
            if (i != index) {
                var newIndex = i < index ? i : i - 1;
                result[newIndex] = original[i];
            }
        }
        return result;
    }

}
