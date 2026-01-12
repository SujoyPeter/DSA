package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
     public int subarraySum(int[] nums, int k) {
        int count = 0;
    int prefixSum = 0;

    // Map to store prefixSum frequencies
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // base case

    for (int num : nums) {
        prefixSum += num;

        // Check if prefixSum - k exists
        if (map.containsKey(prefixSum - k)) {
            count += map.get(prefixSum - k);
        }

        // Store current prefixSum
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }

    return count;
    }
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = solution.subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result); // Output: 2
    }
}
