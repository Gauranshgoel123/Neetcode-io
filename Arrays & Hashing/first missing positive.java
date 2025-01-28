class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers and zeros with 0
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // Step 2: Mark numbers in the array
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1; // Mark as negative
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (n + 1); // Special marker
                }
            }
        }

        // Step 3: Find the first missing positive
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= 0) {
                return i; // Return the first missing positive
            }
        }

        // Step 4: If all are present, return n+1
        return n + 1;
    }
}
