package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, current, result);
        return result;
    }
    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> current, List<List<Integer>> result) {
        // If current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate over all elements
        for (int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if (used[i]) continue;

            // Include this element
            used[i] = true;
            current.add(nums[i]);

            // Recurse for next element
            backtrack(nums, used, current, result);

            // Backtrack: remove element and mark unused
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = obj.permute(nums);
        System.out.println("All permutations of " + java.util.Arrays.toString(nums) + ": " + permutations);
    }
}
