
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class InputStream1{
    public static void main(String[] args) {
        String filepath = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 10\\Binary Ants.txt";
        try {
            FileInputStream fis = new FileInputStream(filepath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (UnsupportedEncodingException e) {
            System.err.println("Error: The character encoding format is not correct.");
        }
        catch (FileNotFoundException e){
            System.err.println("Error: The file was not found at: " + filepath);
        }
        catch(IOException e){
            System.err.println("Error: An I/O error occured while reading the file.");
        }
    }
}