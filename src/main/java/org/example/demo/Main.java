package org.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("storage.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Path path = file.toPath();

        while (true) {
            String line = new Scanner(System.in).nextLine();
            if (line.startsWith("add ")) {
                String substring = line.substring(4);  // убрал первые 4 символа

                // add to file
                String textToAdd = substring + "\n";
                Files.write(path, textToAdd.getBytes(), StandardOpenOption.APPEND);

            } else if (Objects.equals(line, "print")) {
                for (String storedLine : Files.readAllLines(path)) {
                    System.out.println(storedLine);
                }
            } else if (line.startsWith("delete ")) {
                String substring = line.substring(7);
                int idx = Integer.parseInt(substring);
                List<String> lines = Files.readAllLines(path);  // читаю все линии
                lines.remove(idx);  // удаляю по индексу
                Files.write(path, lines);  // записываю все оставшиеся линии в файл
            } else if (Objects.equals(line, "exit")) {
                break;
            } else {
                System.out.println("only add and exit is valid commands");
            }
        }
    }

}
