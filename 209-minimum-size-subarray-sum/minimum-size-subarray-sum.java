



 class Solution  {
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0, currentSum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right]; // Expand the window by adding the right element

            // While the current sum is greater than or equal to s, shrink from the left
            while (currentSum >= s) {
                minLength = Math.min(minLength, right - left + 1); // Update the minimum length
                currentSum -= nums[left++]; // Shrink the window from the left
            }
        }

        // If minLength was updated, return it; otherwise, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(s, nums);
        System.out.println("The minimum size subarray sum is == " + result); // Output: 2
    }
}