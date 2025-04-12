import java.util.*;
public class LBCompare{
    public static int LinearSearch(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==target){return i;}
        }
        return -1;
    }
    public static int BinarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(target<arr[mid]) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
    public static void testsearchPerformance(int datasize, int target){
        Random random = new Random();
        int[] num = new int[datasize];
        for(int i=0; i<datasize; i++){
            num[i] = random.nextInt(datasize*10);
        }
        long startlinear = System.nanoTime();
        LinearSearch(num, target);
        long endlinear = System.nanoTime();
        long LinearTime = endlinear - startlinear;
        Arrays.sort(num);
        long startbinary = System.nanoTime();
        BinarySearch(num, target);
        long endbinary = System.nanoTime();
        long BinaryTime = endbinary - startbinary;
        System.out.printf("Array size: %,d", datasize);
        System.out.printf("For Linear Search time taken is: %.3f ms\n" , LinearTime/1_000_000);
        System.out.printf("For Binary Search time taken is: %.3f ms" , BinaryTime/1_000_000);
    }
    public static void main(String[] args) {
        int target = -1;
        testsearchPerformance(1_000, target);
        testsearchPerformance(10_000, target);
        testsearchPerformance(1_000_000, target);
    }
}