import java.util.Scanner;
public class BinarySearch1{
    public static int rotationindex(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid] > arr[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        int index = rotationindex(arr);
        System.out.println("The index is: " + index);
        System.out.println("Element is: " + arr[index]);
        scanner.close();
    }
}