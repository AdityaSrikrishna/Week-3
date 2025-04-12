import java.util.Scanner;
public class LinearSearch2{
    public static String findsentence(String[] sentences, String word){
        for(String sentence : sentences){
            if(sentence.contains(word)){
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of sentences:");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] sentences = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the sentence " + (i+1) + ":");
            sentences[i] = scanner.nextLine();
        }
        System.out.println("Enter the word to search:");
        String word = scanner.nextLine();

        String result = findsentence(sentences, word);
        System.out.println("The result is: " + result);
        scanner.close();
    }
}