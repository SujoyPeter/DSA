package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
     public List<List<String>> partition(String s) {
         // Initialize result and temporary path
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        // Start backtracking from index 0
        backtrack(0, s, path, res);
        return res;
    }
    private boolean isPalindrome(String s, int start, int end) {
        // Loop while start is less than end
        while (start < end) {
            // If characters at start and end are not equal, it's not a palindrome
            if (s.charAt(start) != s.charAt(end)) return false;
            // Move start forward and end backward
            start++;
            end--;
        }
        // If all characters matched, it's a palindrome
        return true;
    }

    // Backtracking function to generate all possible palindrome partitions
    private void backtrack(int index, String s, List<String> path, List<List<String>> res) {
        // If index reached the end of string, add the current path to result
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Try all possible substrings starting from index
        for (int i = index; i < s.length(); i++) {
            // Check if current substring is palindrome
            if (isPalindrome(s, index, i)) {
                // Add substring to current path
                path.add(s.substring(index, i + 1));
                // Recur for the next index
                backtrack(i + 1, s, path, res);
                // Backtrack by removing the last added substring
                path.remove(path.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> partitions = obj.partition(s);
        System.out.println("Palindrome partitions of \"" + s + "\": " + partitions);
    }
}
