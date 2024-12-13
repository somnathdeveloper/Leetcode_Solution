class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        // Create a 2D array to store each number along with its original index
        int[][] arr = new int[n][2];

        // Populate the 2D array with numbers and their indices
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // Store the value
            arr[i][1] = i;       // Store the index
        }

        // Sort the array based on the value; if values are equal, sort by index
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // Sort by index if values are equal
            return a[0] - b[0];                   // Otherwise, sort by value
        });

        Set<Integer> set = new HashSet<>(); // To track indices that have been visited or skipped
        long score = 0; // Initialize the score to 0

        // Iterate through the sorted array
        for (int i = 0; i < n; i++) {
            int val = arr[i][0]; // Current value
            int idx = arr[i][1]; // Original index of the current value

            // Check if the current index is not already in the set
            if (!set.contains(idx)) {
                score += val;   // Add the value to the score
                set.add(idx);   // Mark the current index as visited
                set.add(idx + 1); // Mark the next index as skipped
                set.add(idx - 1); // Mark the previous index as skipped
            }
        }
        return score; // Return the final score
    }
}