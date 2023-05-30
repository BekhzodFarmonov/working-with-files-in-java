package uz.pdp.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String filePath="src/uz/pdp/io/test.txt";
        File file=new File(filePath);
        Path path=file.toPath();
        file=path.toFile();
        try {
            if (file.createNewFile()) {
                System.out.println("File have created");
            }else {
                System.out.println("File not created");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
