class Solution {
    public int diagonalPrime(int[][] nums) {
        fill();
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (p[nums[i][i]]) {
                max = Math.max(max, nums[i][i]);
            }
            if (p[nums[i][n - i - 1]]) {
                max = Math.max(max, nums[i][n - i - 1]);
            }
        }
        return max;
    }
    
    boolean[] p = new boolean[4 * 1000000 + 1];
    private void fill() {
        Arrays.fill(p, true);
        int n = 4 * 1000000;
        for (int i = 2; i * i <= n; i++) {
            if (!p[i]) continue;
            for (int j = 2 * i; j <= n; j += i) {
                p[j] = false;
            }
        }
        p[0] = p[1] = false;
    }
}