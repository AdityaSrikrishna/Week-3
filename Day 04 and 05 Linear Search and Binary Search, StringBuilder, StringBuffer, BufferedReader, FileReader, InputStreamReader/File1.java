import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File1{
    public static void main(String[] args) {
        String filepath = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 10\\Ant.txt";
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e){
            System.out.println("Some error occured while printing lines.");
            e.printStackTrace();
        }
    }
}