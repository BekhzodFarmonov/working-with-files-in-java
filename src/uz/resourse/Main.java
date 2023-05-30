package uz.resourse;

import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, String> lugat = new HashMap<>();
    ;
    static User user = new User();

    public static void main(String[] args) {
        Path path = Path.of("D:\\Full module rar\\module 4.Threads.Rar\\Lesson7\\src\\uz\\resourse\\application.properties");
        UserAdmin(path);
        Path path1 = Path.of("D:\\Full module rar\\module 4.Threads.Rar\\Lesson7\\src\\uz\\resourse\\users.txt");
        User(path1);

    }

    static void UserAdmin(Path pathname) {
        try {
            BufferedReader reader = Files.newBufferedReader(pathname);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("=");
                if (words.length == 2) {
                    String word = words[0].trim().toLowerCase();
                    String meaning = words[1].trim().toLowerCase();
                    lugat.put(word, meaning);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lugat.forEach((s, s2) ->
                System.out.println("UserAdming" + "->" +
                        "Idlari" + " " + s + " " +
                        "ga mos kodlari" + " " + "->" + s2));

    }

    static void User(Path path) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            String qidirilayotganSoz = "create";
            if (lugat.containsKey(qidirilayotganSoz)) {
                String meaning = lugat.get(qidirilayotganSoz);
                if (meaning.equals("true")) {
                    Faker faker=new Faker();
                    List<User> users=new ArrayList<>();
                    for (int i = 0; i < 100; i++) {
                        users.add(new User(faker.idNumber().toString(),
                                faker.name().toString(), UserType.USER,
                                faker.date().toString()));
                    }
                    writer.write(users.toString());
                    writer.close();
                }}
            System.out.println("User writer in text");
            }
        catch(IOException e){
                e.printStackTrace();
            }
        }
    }