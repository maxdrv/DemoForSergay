package org.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WriteReadFile {

    @DisplayName("Вставить содержимое в файл с заменой")
    @Test
    void insertContentIntoFile() throws IOException {
        String text = "any text to write";
        File file = new File("file.txt");  // файл в текущей папка, где запускается программа
        Files.write(file.toPath(), text.getBytes());  // полностью затираем старое содержимое файла, заменяем на новое содержимое
    }

    @DisplayName("Дописать в конец файла")
    @Test
    void appendNewLineToFile() throws IOException {
        File file = new File("file.txt");
        Files.write(file.toPath(), "\n".getBytes(), StandardOpenOption.APPEND);  // добавили перенос строки
        String secondLine = "second line";
        Files.write(file.toPath(), secondLine.getBytes(), StandardOpenOption.APPEND);
    }

    @DisplayName("Прочитать файл построчно")
    @Test
    void readAllLinesFromFile() throws IOException {
        File file = new File("file.txt");
        List<String> lines = Files.readAllLines(file.toPath());

        assertThat(lines)
                .containsExactly("any text to write", "second line");
    }

    @DisplayName("Прочитать файл целиком")
    @Test
    void readWholeFile() throws IOException {
        File file = new File("file.txt");
        String content = Files.readString(file.toPath());
        assertThat(content)
                .contains("any text to write\nsecond line");
    }

    @Test
    void howToTranslateCheckedExceptionIntoUnchecked() {
        String content = read();
    }

    private String read() {
        File file = new File("file.txt");
        try {
            return Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
