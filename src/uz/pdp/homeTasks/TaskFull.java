package uz.pdp.homeTasks;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
public class TaskFull {
    public static void main(String[] args) throws IOException {
        Calendar calendar=Calendar.getInstance();

       // 1
        /*Path pathname= Path.of("src/test.txt");
      task1(pathname);*/
        //2
        /* Path pathname=Path.of(".");
        boolean hasSubdirectoryOrFile = task2(pathname);
        if (hasSubdirectoryOrFile) {
            System.out.println("Papka ichida papka yoki fayl mavjud.");
        } else {
            System.out.println("Papka ichida papka va fayl yo'q.");
        }*/
        //3
       /* Path pathname=Path.of("src/uz/pdp/nio/test.txt");
        task3(pathname);*/
       /* Path pathname1=Path.of("src/uz/pdp/nio/test.txt");
        task4(pathname1);*/
       /* Path path1=Path.of("src/uz/pdp/nio/test.txt");
        Path path2=Path.of("D:\\Full module rar\\module 4.Threads.Rar\\Lesson7\\src\\uz\\pdp\\test1.txt");
        Path path3=Path.of("D:\\Full module rar\\module 4.Threads.Rar\\Lesson7\\src\\uz\\pdp\\io\\test.txt");
        task5(path1,path2,path3);*/
        /*Path path=Path.of("D:\\Full module rar\\module 4.Threads.Rar\\Lesson7\\src\\uz\\pdp\\homeTasks\\dictoatry.txt");
        task6(path);*/
        //task7();
        task8();

    }
    static  void task1(Path pathname){
        System.out.println(
                pathname.getFileName());
    }
    static boolean task2(Path pathname){
            boolean hasSubdirectoryOrFile = false;
            try {
                hasSubdirectoryOrFile = Files.list(pathname).
                        anyMatch(p -> Files.isDirectory(p)
                                || Files.isRegularFile(p));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return hasSubdirectoryOrFile;
    }
    static void  task3(Path pathname){
        int lineCount=0;
        try (BufferedReader reader = Files.newBufferedReader(pathname)) {

            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lineCount+ " ta qator bor");
    }
    static  void  task4(Path pathname){
        String str="";
        try (BufferedReader reader=Files.newBufferedReader(pathname)){
            String line;
            while ((line=reader.readLine())!= null) {
    String[] words=line.split(",");
     for(String word:words){
         if (word.length()>str.length()){
             str=word;
         }
     }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
    static  void  task5(Path pathname1,Path pathname2,Path pathname3) throws IOException {
        BufferedReader reader1=Files.newBufferedReader(pathname1);
        BufferedReader reader2=Files.newBufferedReader(pathname2);
        BufferedWriter writer=Files.newBufferedWriter(pathname3);
        String line;
        while ( reader1.readLine() != null) {
            writer.write(reader1.readLine());
            writer.newLine();
        }

        while ((line = reader2.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }
        reader1.close();
        reader2.close();
        writer.close();
        System.out.println("fayyllar birlashtirldi va yangi faylga yozildi");
    }
    static  void task6(Path pathname){
        Map<String, String> lugat = new HashMap<>();
        try {
            BufferedReader reader=Files.newBufferedReader(pathname);
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
        String qidirilayotganSoz = "monkey";
        if (lugat.containsKey(qidirilayotganSoz)) {
            String meaning = lugat.get(qidirilayotganSoz);
            System.out.println(qidirilayotganSoz + " ning ma'nosi: " + meaning);
        } else {
            System.out.println(qidirilayotganSoz + " topilmadi.");
    }
}
  static  void task7(){
      String root="src\\uz\\entity";
      int myYear=2002;
      String address = root + "\\" + myYear;
      Path path=Path.of(address);
      try {
          Files.createDirectory(path);
          Path pathMonth;
          for(Month month:Month.values()){
              pathMonth = Path.of(address + "//" + month.name());
              Files.createDirectory(pathMonth);
              YearMonth yearMonth=YearMonth.of(myYear,month);
              int daysInMonth = yearMonth.lengthOfMonth();

              for (int i = 1; i <= daysInMonth; i++) {
                  File file = new File(address + "//"
                          + month.name()+"//"+i+"."+month.getValue()+"."
                          +myYear+".txt");
                  FileWriter fileWriter = new FileWriter(file);
                  fileWriter.write(LocalDateTime.now().toString());
                  fileWriter.close();
              }
          }
      } catch (
              IOException e) {
          e.printStackTrace();
      }
  }
  static void
  task8() throws IOException {
        File file=new File("D:\\Full module rar\\module 4.Threads.Rar\\Lesson7\\src\\uz\\regax\\regaax.txt");
        FileWriter fileWriter=new FileWriter(file);

        fileWriter.write("this regax essantiol your life");
        fileWriter.close();

      System.out.println("sucseesful!!");

    }
}