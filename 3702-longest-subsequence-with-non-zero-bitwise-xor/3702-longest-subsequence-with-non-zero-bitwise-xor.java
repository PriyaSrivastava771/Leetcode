class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;

        // XOR of all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Whole array has non-zero XOR
        if (xor != 0) {
            return nums.length;
        }

        // Total XOR is zero, check for any non-zero element
        for (int num : nums) {
            if (num != 0) {
                return nums.length - 1;
            }
        }

        // All elements are zero
        return 0;
        
    }
}
