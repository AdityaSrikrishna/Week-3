import java.io.*;
import java.util.*;
public class TestFileReader{
    public static void generateLargeFile(String filename, int filesizeinMB) throws IOException{
        Random rand = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            long totalcharacters = filesizeinMB * 1024 * 1024;
            for(int i=0; i<totalcharacters; i++){
                writer.write(chars.charAt(rand.nextInt(chars.length())));
            }
            System.out.println("File generated : " + filename);
        }
    }
    public static void testFileReader(String filename) throws IOException{
        long start = System.nanoTime();
        try(FileReader fr = new FileReader(filename)){
            while(fr.read()!=-1){

            }
        }
        long end = System.nanoTime();
        System.out.println("Time taken by File Reader for reading is: " + (end-start)/1_000_000 + "ms");
    }
    public static void testInputStreamReader(String filename) throws IOException{
        long start = System.nanoTime();
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(filename))){
            while(isr.read()!=-1){

            }
        }
        long end = System.nanoTime();
        System.out.println("Time taken by Input Stream Reader for reading is: " + (end-start)/1_000_000 + "ms");
    }
    public static void main(String[] args) throws IOException{
        String filename = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 11\\LargeFile.txt";
        File file = new File(filename);
        int filesizeinMB = 500;
        if (!file.exists()) {
            generateLargeFile(filename, filesizeinMB);
        }
        testFileReader(filename);
        testInputStreamReader(filename);
    }
}