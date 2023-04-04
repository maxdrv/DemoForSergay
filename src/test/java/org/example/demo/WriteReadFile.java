package org.example.demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WriteReadFile {

    @Test
    void writeFile() throws IOException {
        String text = "any text to write";
        File file = new File("file.txt");  // файл в текущей папка, где запускается программа
        Files.write(file.toPath(), text.getBytes());

        Files.write(file.toPath(), "\n".getBytes(), StandardOpenOption.APPEND);  // перевод на следующую строку

        String secondLine = "second line";
        Files.write(file.toPath(), secondLine.getBytes(), StandardOpenOption.APPEND);
    }

    @Test
    void readFile() throws IOException {
        File file = new File("file.txt");
        List<String> lines = Files.readAllLines(file.toPath());

        assertThat(lines)
                .containsExactly("any text to write", "second line");
    }


}
