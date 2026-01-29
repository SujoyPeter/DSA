package LinkedList_Array;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
         int cnt = 0;
        // Variable to store maximum consecutive 1's
        int maxi = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If current element is 1, increment count
            if (nums[i] == 1) {
                cnt++;
            } else {
                // If element is 0, reset count
                cnt = 0;
            }

            // Update maximum if current count is greater
            maxi = Math.max(maxi, cnt);
        }

        // Return maximum consecutive 1's
        return maxi;
    }
    public static void main(String[] args) {
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println("Maximum consecutive 1's: " + obj.findMaxConsecutiveOnes(nums));
    }
}
