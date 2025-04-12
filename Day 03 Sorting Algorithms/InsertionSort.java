import java.util.Scanner;
public class InsertionSort{
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of empoylees:");
        int n = scanner.nextInt();
        int[] empid = new int[n];
        for(int i=0; i<n; i++){
            empid[i] = scanner.nextInt();
        }
        System.out.println("Array before sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(empid[i] + " ");
        }
        for(int i=1; i<n; i++){
            int key = empid[i];
            int j = i-1;
            while(j>=0 && empid[j]>key){
                empid[j+1] = empid[j];
                j=j-1;
            }
            empid[j+1] = key;
        }
        System.out.println();
        System.out.println("Array after sorting:");
        for(int emp: empid){
            System.out.print(emp + " ");
        }
    }
}