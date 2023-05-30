package uz.pdp.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        Path path = Path.of("src/uz/pdp/nio/test");
//        Path path1 = Paths.get("src/uz/pdp/nio/test.txt");
        try {
            path = Files.createFile(path);
        } catch (IOException e) {
            System.out.println("File yartilmadi");
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        System.out.println("path.getName(0) = " + path.getName(1));
        System.out.println("path.getNameCount() = " + path.getNameCount());
        path.forEach(path1 -> System.out.println(path1));
        System.out.println("path.getFileSystem().getSeparator() = " + path.getFileSystem().getSeparator());
        System.out.println("path.getFileName() = " + path.getFileName());


    }
}
