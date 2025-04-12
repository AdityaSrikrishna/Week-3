import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findSubarraysWithZeroSum(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0;
        map.put(0, new ArrayList<>(List.of(-1))); // base case for sum = 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If current sum is seen before, all subarrays from previous index+1 to i have sum 0
            if (map.containsKey(sum)) {
                for (int startIdx : map.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Add this sum to the map
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        List<int[]> subarrays = findSubarraysWithZeroSum(arr);

        System.out.println("Zero-sum subarrays (start to end indices):");
        for (int[] pair : subarrays) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
