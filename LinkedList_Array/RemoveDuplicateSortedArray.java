package LinkedList_Array;

public class RemoveDuplicateSortedArray {
 public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // Pointer for last unique element
        int i = 0;

        // Start from second element
        for (int j = 1; j < nums.length; j++) {
            // If new unique element is found
            if (nums[j] != nums[i]) {
                // Move unique position forward
                i++;
                // Place new unique element
                nums[i] = nums[j];
            }
        }

        // i is last index of unique element, count = i + 1
        return i + 1;
    }
    public static void main(String[] args) {
        RemoveDuplicateSortedArray remover = new RemoveDuplicateSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int newLength = remover.removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }   
}
