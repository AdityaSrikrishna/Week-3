import java.util.Arrays;
import java.util.Random;

public class SortingCompare{
    public static void BubbleSort(int[] arr){
        boolean swapped;
        for(int i=0; i<arr.length; i++){
            swapped = false;
            for(int j=0; j<arr.length - i - 1; j++){
                if(arr[j]> arr[j+1]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
    public static void MergeSort(int[] prices, int left, int right){
        if(left>=right) return;
        int mid = left + (right-left)/2;
        MergeSort(prices, left, mid);
        MergeSort(prices, mid+1, right);
        merge(prices, left, mid, right);
    }
    public static void merge(int[] prices, int left, int mid, int right){
        int n1 = mid - left+1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for(int i=0; i<n1; i++){
            leftArray[i] = prices[left + i];
        }
        for(int j=0; j<n2; j++){
            rightArray[j] = prices[mid+1 + j];
        }
        int i=0, j=0, k=left;
        while(i<n1 && j<n2){
            if(leftArray[i]<=rightArray[j]){
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
    public static void quickSort(int[] prices, int low, int high){
        if(low<high){
            int partitionIndex = partition(prices, low, high);
            quickSort(prices, low, partitionIndex-1);
            quickSort(prices, partitionIndex+1, high);
        }
    }
    public static int partition(int[] prices, int low, int high){
        int pivot = prices[high];
        int i=low-1;
        for(int j=low; j<high; j++){
            if(prices[j]<pivot){
                i++;
                int temp = prices[j];
                prices[j] = prices[j+1];
                prices[j+1] = temp;
            }
        }
        int temp = prices[i+1];
        prices[i+1] = prices[high];
        prices[high] = temp;
        return i+1;
    }
    public static void testperformancestring(int datasize){
        Random random = new Random();
        int[] arr = new int[datasize];
        for(int i=0; i<datasize; i++){
            arr[i] = random.nextInt(datasize*10);
        }
        int[] bubble = Arrays.copyOf(arr, datasize);
        if(datasize<=10000){
            long startbubble = System.nanoTime();
            BubbleSort(bubble);
            long endbubble = System.nanoTime();
            long finalbubbletime = endbubble - startbubble;
            System.out.println("Bubble sort time: " + finalbubbletime/1_000_000 + "ms");
        }
        else{
            System.out.println("Bubble sort too slow to sort.");
        }
        int[] merge = Arrays.copyOf(arr, datasize);
        long startmerge = System.nanoTime();
        MergeSort(merge, 0, datasize-1);
        long endmerge = System.nanoTime();
        long finalmergetime = endmerge - startmerge;
        int[] quick = Arrays.copyOf(arr, datasize);
        long startquick = System.nanoTime();
        quickSort(quick, 0, datasize-1);
        long endquick = System.nanoTime();
        long finalquicktime = endquick - startquick;
        System.out.println("The datasize is: " + datasize);
        System.out.println("Merge sort time: " + finalmergetime/1_000_000 + "ms");
        System.out.println("Quick sort time: " + finalquicktime/1_000_000 + "ms");
    }
    public static void main(String[] args) {
        testperformancestring(1_000);
        testperformancestring(10_000);
        testperformancestring(1_000_000);
    }
}