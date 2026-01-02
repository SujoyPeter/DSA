package Arrays;

public class FindMissingAndRepeatingValues {
    public int[] findMissingAndRepeatedValues(int[][] nums) {
         int n = nums.length;
        int size = n * n;

        int xr = 0;

        // XOR all matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                xr ^= nums[i][j];
            }
        }

        // XOR with numbers from 1 to n*n
        for (int i = 1; i <= size; i++) {
            xr ^= i;
        }

        // Rightmost set bit
        int bit = xr & -xr;

        int zero = 0, one = 0;

        // Divide matrix elements into two groups
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((nums[i][j] & bit) != 0)
                    one ^= nums[i][j];
                else
                    zero ^= nums[i][j];
            }
        }

        // Divide numbers 1 to n*n into two groups
        for (int i = 1; i <= size; i++) {
            if ((i & bit) != 0)
                one ^= i;
            else
                zero ^= i;
        }

        // Identify which is repeating
        int count = 0;
        for (int[] row : nums) {
            for (int val : row) {
                if (val == zero) count++;
            }
        }

        if (count == 2) return new int[]{zero, one};
        return new int[]{one, zero};
    }
    public static void main(String[] args) {

        FindMissingAndRepeatingValues obj = new FindMissingAndRepeatingValues();

        // Example input (n = 3, numbers should be from 1 to 9)
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 8}   // 8 is repeating, 9 is missing
        };

        int[] result = obj.findMissingAndRepeatedValues(nums);

        System.out.println("Repeating Number: " + result[0]);
        System.out.println("Missing Number: " + result[1]);
    }
}
