package org.example.demo;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class TryCatchWithResources {

    @Test
    void simpleTryCatch() {
        java.io.File file1 = new java.io.File("non_existent");

        System.out.println("before try catch");
        try {
            String s = Files.readString(file1.toPath());  // файл не существует поэтому будет ошибка при попытке чтения
        } catch (IOException e) {
            System.out.println("inside catch");
            throw new RuntimeException(e);  // бросаем ошибку снова - произойдет выход из метода simpleTryCatch(), потому что эту ошибку уже никто не отлавливает
        }

        System.out.println("after try catch");  // этот блок не исполнится

    }

    @Test
    void tryWithResource() throws IOException {
        String path = "existent.txt";

        try (FileOutputStream output = new FileOutputStream(path)) {
            output.write(1);
        }  // close будет вызван автоматически
    }
}
