import java.util.Scanner;
public class SelectionSort{
    public static void selectionsort(int[] scores){
        int n = scores.length;
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(scores[j]<scores[i]){
                    min=j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[min];
            scores[min] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students:");
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for(int i=0; i<n; i++){
            scores[i] = scanner.nextInt();
        }
        System.out.println("Array before sorting:");
        for(int score : scores){
            System.out.print(score + " ");
        }
        System.out.println();
        selectionsort(scores);
        System.out.println("Array after sorting:");
        for(int score : scores){
            System.out.print(score + " ");
        }
        scanner.close();
    }
}