import java.util.*;

public class CountingSortAges {
    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count frequencies
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative counts
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place in output (stable sort: go from end to start)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            int pos = count[age - minAge] - 1;
            output[pos] = age;
            count[age - minAge]--;
        }

        // Step 4: Copy output to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 14, 11, 10, 13, 15, 12, 18, 16, 14, 11};

        System.out.println("Before Sorting: " + Arrays.toString(studentAges));
        countingSort(studentAges);
        System.out.println("After Sorting: " + Arrays.toString(studentAges));
    }
}
