package org.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("storage.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Path path = file.toPath();

        while (true) {
            String input = new Scanner(System.in).nextLine();
            if (input.startsWith("add ")) {
                String substring = input.substring(4);  // убрал первые 4 символа

                // add to file
                String textToAdd = substring + "\n";
                Files.write(path, textToAdd.getBytes(), StandardOpenOption.APPEND);

            } else if (Objects.equals(input, "print")) {
                List<String> lines = Files.readAllLines(path);
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);
                    System.out.println(line);
                }
            } else if (input.startsWith("delete ")) {
                StringTokenizer tokenizer = new StringTokenizer(input, " ");

                tokenizer.nextToken();  // пропускаю delete
                if (!tokenizer.hasMoreTokens()) {
                    System.out.println("в delete не указан способ удаления");
                    continue;
                }
                String deleteType = tokenizer.nextToken();
                if (!tokenizer.hasMoreTokens()) {
                    System.out.println("после типа delete не указан параметр");
                    continue;
                }
                String parameter = tokenizer.nextToken();

                if (Objects.equals(deleteType, "idx")) {
                    int idx = Integer.parseInt(parameter);
                    deleteByIndex(path, idx);
                } else if (Objects.equals(deleteType, "sub")) {
                    deleteBySubstring(path, parameter);
                } else {
                    System.out.println("не известный тип delete");
                    continue;
                }
            } else if (Objects.equals(input, "exit")) {
                break;
            } else {
                System.out.println("only add and exit is valid commands");
            }
        }
    }

    private static void deleteByIndex(Path path, int idx) throws IOException {
        List<String> lines = Files.readAllLines(path);  // читаю все линии
        lines.remove(idx);                              // удаляю по индексу
        Files.write(path, lines);                       // записываю все оставшиеся линии в файл
    }

    private static void deleteBySubstring(Path path, String substring) throws IOException {
        List<String> lines = Files.readAllLines(path);  // читаю все линии
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {        // проходим по всему файлу
            String line = lines.get(i);
            if (!line.contains(substring)) {            // если строка не содержит подстроку
                result.add(line);                       // то оставляем ее в результате
            }
        }
        Files.write(path, result);                      // записываю все оставшиеся строки
    }

}
