import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Count{
    public static void main(String[] args) {
        String filepath = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 10\\Ant.txt";
        String targetword = "ant";
        int count = 0;
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                String[] words = line.split("\\W+");
                for(String word : words){
                    if(word.equalsIgnoreCase(targetword)){
                        count++;
                    }
                }
            }
            System.out.println("The word " + targetword + " occurs " + count + " times");
        } catch (IOException e) {
            System.out.println("Error occured while reading the line");
            e.printStackTrace();
        }
    }
}