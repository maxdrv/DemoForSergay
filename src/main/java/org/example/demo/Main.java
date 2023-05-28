package org.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String FILE_TO_STORE = "storage.txt";

    public static void main(String[] args) throws IOException {
        List<String> storedLines;

        File file = new File(FILE_TO_STORE);
        if (file.exists()) {
            storedLines = Files.readAllLines(file.toPath());
        } else {
            file.createNewFile();
            storedLines = new ArrayList<>();
        }

        while (true) {
            String line = new Scanner(System.in).nextLine();
            if (line.startsWith("add ")) {
                String substring = line.substring(4);
                storedLines.add(substring);

                // add to file
                String textToAdd = substring + "\n";
                Files.write(file.toPath(), textToAdd.getBytes(), StandardOpenOption.APPEND);

            } else if (Objects.equals(line, "print")) {
                for (String storedLine : storedLines) {
                    System.out.println(storedLine);
                }
            } else if (Objects.equals(line, "exit")) {
                break;
            } else {
                System.out.println("only add and exit is valid commands");
            }
        }
    }

}
