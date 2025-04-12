import java.io.*;
public class InputStream2{
    public static void main(String[] args) {
        String filepath = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 10\\New Doc.txt";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fr = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fr);
            String inputline;
            System.out.println("Enter text (type exit to finish):");
            while (true) { 
                System.out.print("> ");
                inputline = br.readLine();
                if("exit".equalsIgnoreCase(inputline)){
                    break;
                }
                bw.write(inputline);
                bw.newLine();      
            }
            System.out.println("Input saved to New Doc.txt");
            isr.close();
            br.close();
            fr.close();
            bw.close();
        } catch (IOException e) {
            System.err.println("Error: An I/O error has occured.");
        }
    }
}