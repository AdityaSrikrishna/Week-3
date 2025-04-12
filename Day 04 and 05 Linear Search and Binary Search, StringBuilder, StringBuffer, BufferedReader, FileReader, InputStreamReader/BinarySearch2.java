import java.util.Scanner;
public class BinarySearch2{
    public static int findpeakelement(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            boolean leftok = (mid==arr[0] || arr[mid]>arr[mid-1]);
            boolean rightok = (mid == arr[n-1] || arr[mid]>arr[mid+1]);
            if(leftok&&rightok){
                return mid;
            }
            if(mid!=0 && arr[mid]<arr[mid-1]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        int peak = findpeakelement(arr);
        System.out.println("Peak element index is: " + peak);
        System.out.println("Peak element is: " + arr[peak]);
        scanner.close();
    }
}