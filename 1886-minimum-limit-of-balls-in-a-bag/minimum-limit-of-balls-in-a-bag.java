class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 0, right = 0;
        
        // Determine the initial range for binary search.
        // `right` is set to the maximum number in `nums` because 
        // the largest number is the theoretical upper bound for the minimum size.
        for (int i : nums) {
            right = Math.max(right, i);
        }

        // Initialize `ans` with the maximum possible size of a bag.
        int ans = right;

        // Perform binary search to find the smallest possible maximum size of a bag.
        while (left <= right) {
            int mid = (left + right) / 2; // Midpoint of current range.

            // Check if it's possible to split the bags such that 
            // no bag has more than `mid` balls with the given operations.
            if (valid(mid, nums, maxOperations)) {
                ans = mid;        // Update the answer with the current valid `mid`.
                right = mid - 1; // Try for a smaller maximum size.
            } else {
                left = mid + 1;  // Increase the minimum size limit to find a valid solution.
            }
        }
        return ans; // Return the smallest valid maximum size.
    }

    // Helper function to determine if a given `mid` is a valid maximum size for the bags.
    private boolean valid(int mid, int[] nums, int maxo) {
        int o = 0; // Count of operations needed to make all bags <= `mid`.

        for (int num : nums) {
            // Calculate the number of splits needed for the current bag
            // to make all parts <= `mid`. Subtract 1 because no operation is needed
            // if the size is already less than or equal to `mid`.
            o += (int) Math.ceil(num / (double) mid) - 1;

            // If operations exceed `maxo`, `mid` is not valid.
            if (o > maxo) return false;
        }
        return true; // All bags can be split within the allowed operations.
    }
}