import java.util.Scanner;

public class ReverseString{
    public static String Reverse(String string){
        StringBuilder reversed = new StringBuilder();
        for(int i=string.length()-1; i>=0; i--){
            reversed.append(string.charAt(i));
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String reverse = Reverse(string);
        System.out.println("Original String: " + string);
        System.out.println("Reversed String: " + reverse);
        scanner.close();
    }
}