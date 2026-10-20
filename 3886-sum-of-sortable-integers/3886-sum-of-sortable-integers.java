class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            if (isSortable(nums, k)) {
                totalSum += k;
            }
        }

        return totalSum;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int numBlocks = n / k;
        int prevMax = Integer.MIN_VALUE;

        for (int b = 0; b < numBlocks; b++) {
            int start = b * k;
            int end = start + k;

            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = start; i < end; i++) {
                minVal = Math.min(minVal, nums[i]);
                maxVal = Math.max(maxVal, nums[i]);
            }
            if (b > 0 && minVal < prevMax) {
                return false;
            }

            if (!canRotateSorted(nums, start, k)) {
                return false;
            }

            prevMax = maxVal;
        }

        return true;
    }

    private boolean canRotateSorted(int[] nums, int start, int k) {
        int drops = 0;
        for (int i = 0; i < k; i++) {
            int curr = nums[start + i];
            int next = nums[start + (i + 1) % k];
            if (curr > next) {
                drops++;
            }
        }
        return drops <= 1;
    }
}
