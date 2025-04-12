import java.util.Arrays;

public class ChallengeProblem2 {

    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Mark elements as visited by marking numbers out of range or negative
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;  // Use a number outside the valid range
            }
        }

        // Use the array indices to mark numbers that appear in the array
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);  // Mark as visited
            }
        }

        // Find the first index with a positive number, which indicates the missing integer
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;  // Return the first missing positive integer
            }
        }

        return n + 1;  // If all numbers from 1 to n are present, return n + 1
    }

    // Method to perform Binary Search to find the index of a target number
    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums);  // Sort the array before performing Binary Search
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;  // Target found, return index
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;  // Target not found, return -1
    }

    public static void main(String[] args) {
        // Example array for finding the first missing positive
        int[] nums1 = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums1));

        // Example array for performing Binary Search
        int[] nums2 = {5, 3, 7, 2, 8, 1, 4};
        int target = 7;
        int index = binarySearch(nums2, target);
        System.out.println("Index of " + target + ": " + (index != -1 ? index : "Not found"));
    }
}
