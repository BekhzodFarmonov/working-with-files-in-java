package uz.pdp.nio.sream;

import uz.pdp.User;
import uz.pdp.UserType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("src/uz/pdp/nio/test.txt");
        Path path1 = Path.of("uz/resourse/users.txt");
//        outputStreamExample(path);
//        bufferedReaderExample(path);
//        bufferedWriterExample(path);
        objectOutputStream(path1);
        objectInputStream(path1);
    }
    static void outputStreamExample(Path path) {
        try (OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.APPEND)) {
            outputStream.write("Hello".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void inputStreamExample(Path path) {
        try (InputStream outputStream = Files.newInputStream(path, StandardOpenOption.APPEND)) {
            // ....
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void bufferedReaderExample(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);

            // ....
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void bufferedWriterExample(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            String[] lines = {"sdsfds", "sfdsdfsdfsd", "xcxzcxcv"};
            for (String line : lines) {
                writer.write(line);
            }

            // ....
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void objectOutputStream(Path path){// serialization
        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))) {
            User user=new User("login","password", UserType.ADMIN);
            User user1=new User("login1","password1", UserType.USER);
            objectOutputStream.writeObject(user);
            objectOutputStream.writeObject(user1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new
                    RuntimeException(e);
        }
    }
    static void objectInputStream(Path path){// de-serialization
        try (var objectIntputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            User user= (User) objectIntputStream.readObject();
            User user1= (User) objectIntputStream.readObject();
            System.out.println(user);
            System.out.println(user1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
