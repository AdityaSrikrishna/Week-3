import java.util.Scanner;
public class StringBuffer1{
    public static String Concatenate(String[] strings){
        StringBuffer buffer = new StringBuffer();
        for(String c : strings){
            buffer.append(c);
        }
        return buffer.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for(int i=0; i<n; i++){
            strings[i] = scanner.nextLine();
        }
        String result = Concatenate(strings);
        System.out.println("Concatenated String: " + result);
        scanner.close();
    }
}