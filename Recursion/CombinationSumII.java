package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);  // Sort the candidates to handle duplicates
        List<List<Integer>> ans = new ArrayList<>();  // To store the final answer
        List<Integer> ds = new ArrayList<>();  // To store the current combination
        findCombination(0, target, candidates, ans, ds);  // Call the helper function
        return ans;  // Return all valid combinations
    }
    public void findCombination(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        // Base case: If the target becomes 0, we found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(ds));  // Add the current combination to the result
            return;
        }

        // Loop through the elements starting from index 'ind'
        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates to avoid repeating combinations
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // If the current element is greater than the remaining target, break the loop
            if (arr[i] > target) break;

            // Include the current element in the combination
            ds.add(arr[i]);

            // Recur with the updated target and next index (i + 1 to avoid repetition)
            findCombination(i + 1, target - arr[i], arr, ans, ds);

            // Backtrack by removing the last added element
            ds.remove(ds.size() - 1);
        }
    }
    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> combinations = obj.combinationSum2(candidates, target);
        System.out.println("Combinations summing to " + target + ": " + combinations);
    }
}
