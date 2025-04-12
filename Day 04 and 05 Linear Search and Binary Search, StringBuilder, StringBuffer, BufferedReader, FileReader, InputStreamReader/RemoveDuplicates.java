import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates{
    public static String removeDuplicates(String string){
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for(char c : string.toCharArray()){
            if(!seen.contains(c)){
                seen.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        System.out.println("Enter a string:");
        String removeduplicate = removeDuplicates(original);
        System.out.println("Original String:" + original);
        System.out.println("After removing duplicates: " + removeduplicate);
        scanner.close();
    }
}