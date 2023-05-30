package uz.regax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainRegax {
    public static void main(String[] args) {
        /*Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher("5");
        System.out.println(matcher.matches());
        Pattern pattern1=Pattern.compile("cat");
        Matcher matcher1= pattern1.matcher("about cats and dogs");
        while (matcher1.find()){
            System.out.println(matcher1.start()+" "+pattern1.pattern()+" ");
        }
        System.out.println("");
        */
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<WHONE NUMBER WITH REGAX CODE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String phoneNumber = "7199676568";
        String pattern = "^(71|90|91|99|88)\\d{7}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phoneNumber);
        if (matcher.matches()) {
            System.out.println("Valid phone number");
        } else {
            System.out.println("Invalid phone number");
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL WITH REGAX CODE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String email = "sadkhsakdh@mail.com";
        String pattern1 = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern regex1 = Pattern.compile(pattern1);
        Matcher matcher1 = regex1.matcher(email);
        if (matcher1.matches()) {
            System.out.println("Valid email address");
        } else {
            System.out.println("Invalid email address");
        }
      /*   CODE STRONG PASSWORD BO'LISHINI UCHUN
      Minimal uzunligi 8 ta belgi
        Kamida bitta katta harf
        Kamida bitta kichik harf
        Kamida bitta raqam
        Kamida bitta maxsus belgi (pastki chiziq yoki chiziqcha)*/
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<STRONG PASSWORD WITH REGAX CODE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String password2 = "8)Az_0";
        String pattern2 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-_])[A-Za-z\\d-_]{8,}$";
        Pattern regex2 = Pattern.compile(pattern2);
        Matcher matcher2 = regex.matcher(password2);
        if (matcher2.matches()) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}