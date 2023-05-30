package uz.pdp.io;

import java.io.File;

public class FolderExample {
    public static void main(String[] args) {
        File file=new File(".");
        printFiles(file);
    }
    static void printFiles(File directory){
        for (File listFile : directory.listFiles()) {
            if (listFile.isDirectory()) {
                System.out.println(listFile.getName());
                printFiles(listFile);
            }else {
                System.out.println(listFile.getName());
            }

        }
    }
}
