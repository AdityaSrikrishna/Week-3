import java.util.Scanner;

public class MergeSort{
    public static void Mergesort(int[] prices, int left, int right){
        if(left<right){
            int mid = (left + right)/2;
            Mergesort(prices, left, mid);
            Mergesort(prices, mid+1, right);
            merge(prices, left, mid, right);
        }
    }
    public static void merge(int[]prices, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i=0; i<n1; i++){
            leftArray[i] = prices[left + i];
        }
        for(int j=0; j<n2; j++){
            rightArray[j] = prices[mid+1+j];
        }
        int i=0, j=0, k=left;
        while(i<n1 && j<n2){
            if(leftArray[i] <= rightArray[j]){
                prices[k] = leftArray[i];
                i++;
            }
            else{
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            prices[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for(int i=0; i<n; i++){
            prices[i] = scanner.nextInt();
        }
        System.out.println("Array before sorting:");
        for(int price : prices){
            System.out.print(price + " ");
        }
        Mergesort(prices, 0, n-1);
        System.out.println();
        System.out.println("Array after sorting");
        for(int price : prices){
            System.out.print(price + " ");
        }
        scanner.close();
    }
}