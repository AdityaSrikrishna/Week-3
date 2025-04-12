public class BinarySearch4 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        result[0] = findFirstOccurrence(nums, target);
        if (result[0] != -1) {
            result[1] = findLastOccurrence(nums, target);
        }

        return result;
    }

    // Binary search to find the first occurrence of the target
    private static int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;  // continue searching in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    // Binary search to find the last occurrence of the target
    private static int findLastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;  // continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    // Test the function
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
