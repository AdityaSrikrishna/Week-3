import java.util.Scanner;

public class QuickSort{
    public static void quicksort(int prices[], int low, int high){
        if(low<high){
            int partitionIndex = partition(prices, low, high);
            quicksort(prices, low, partitionIndex-1);
            quicksort(prices, partitionIndex+1, high);
        }
    }
    public static int partition(int prices[], int low, int high){
        int pivot = prices[high];
        int i=low-1;
        for(int j=low; j<high; j++){
            if(prices[j]<pivot){
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[i+1];
        prices[i+1] = pivot;
        pivot = temp;
        return i+1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of products:");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for(int i=0; i<n; i++){
            prices[i] = scanner.nextInt();
        }
        System.out.println("Array before sorting:");
        for(int price : prices){
            System.out.print(price + " ");
        }
        quicksort(prices, 0, n-1);
        System.out.println();
        System.out.println("Array after sorting: ");
        for(int price : prices){
            System.out.print(price + " ");
        }
        scanner.close();
    }
}