package uz.pdp.io.streams;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//outputStreamExample();
//writerExample();
//        inputStreamExample();
        readerExample();
    }

    static void outputStreamExample() {
        File file = new File("src/uz/pdp/io/test.txt");
        try (OutputStream outputStream = new FileOutputStream(file, true)) { //try with resource
            outputStream.write("Hello".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void writerExample() {
        File file = new File("src/uz/pdp/io/test.txt");
        try (Writer writer = new FileWriter(file, true)) {
            writer.write("Hello Java!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void inputStreamExample() {
        File file = new File("src/uz/pdp/io/test.txt");
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes();
            for (int i = 0; i < bytes.length; i++) {
                System.out.println((char)bytes[i]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void readerExample(){
        File file = new File("src/uz/pdp/io/test.txt");
        try (Reader reader = new FileReader(file)) {
            char[] chars=new char[(int) file.length()];
            reader.read(chars);
            for (char aChar : chars) {
                System.out.print(aChar);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
