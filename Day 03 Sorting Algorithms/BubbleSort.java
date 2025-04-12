import java.util.Scanner;
public class BubbleSort{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter marks:");
        for(int i=0; i<n; i++){
            marks[i] = scanner.nextInt();
        }
        System.out.println("Array before sorting:");
        for(int i=0; i<n; i++){
            System.out.print(marks[i] + " ");
        }
        System.out.println();
        boolean swapped;
        for(int i=0; i<n; i++){
            swapped = false;
            for(int j=0; j<n-i-1; j++){
                if(marks[j]>marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        System.out.println("Array after sorting:");
        for(int mark: marks){
            System.out.print(mark + " ");
        }
        scanner.close();
    }
}