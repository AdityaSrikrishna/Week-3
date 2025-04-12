import java.util.HashSet;
import java.util.TreeSet;

public class Search{
    public static boolean search(int[] arr, int x){
        for(int num : arr){
            if(num==x) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int N = 1_000_000;
        int searchKey = N-1;
        int[] arr = new int[N];
        HashSet<Integer> hashset = new HashSet<>();
        TreeSet<Integer> treeset = new TreeSet<>();
        
        for(int i=0; i<N; i++){
            arr[i] = i;
            hashset.add(i);
            treeset.add(i);
        }
        long start = System.nanoTime();
        boolean arrSearch = search(arr, searchKey);
        long end = System.nanoTime();
        long finaltime1 = end - start;
        System.out.println("Final search time for Array: " + finaltime1/1_000_000 + "ms");

        start = System.nanoTime();
        boolean hashSearch = hashset.contains(searchKey);
        end = System.nanoTime();
        long finaltime2 = end - start;
        System.out.println("Final search time for Hash Set: " + finaltime2/1_000_000 + "ms");

        start = System.nanoTime();
        boolean treeSearch = treeset.contains(searchKey);
        end = System.nanoTime();
        long finaltime3 = end - start;
        System.out.println("Final search time for Tree Set: " + finaltime3/1_000_000 + "ms");
    }
}