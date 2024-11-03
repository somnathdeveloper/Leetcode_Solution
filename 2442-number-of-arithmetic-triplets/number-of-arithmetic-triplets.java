class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] - nums[j] == diff && nums[j] - nums[i] == diff) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
