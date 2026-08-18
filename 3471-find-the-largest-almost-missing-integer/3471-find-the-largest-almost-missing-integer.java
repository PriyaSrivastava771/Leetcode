import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;

        // Process every subarray of size k
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> seen = new HashSet<>();

            // Add distinct elements of the current subarray
            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }

            // Increase count for each distinct element
            for (int num : seen) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}