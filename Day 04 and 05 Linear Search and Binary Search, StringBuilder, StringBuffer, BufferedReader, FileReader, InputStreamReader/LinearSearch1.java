import java.util.Scanner;
public class LinearSearch1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = scanner.nextInt();
        }
        for(int i=0; i<n; i++){
            if(num[i]<0){
                System.out.println("The index of the negative number is: " + i);
                break;
            }
        }
        scanner.close();
    }
}