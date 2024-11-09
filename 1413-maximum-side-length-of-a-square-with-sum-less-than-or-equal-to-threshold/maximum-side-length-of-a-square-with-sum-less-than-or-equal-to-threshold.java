class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
         int r = mat.length, c = mat[0].length;
        int[][] pre = new int[r+1][c+1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + mat[i-1][j-1];
            }
        }
        
        int res = 0, l = 0;
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                while (i + l <= r && j + l <= c &&
                      (pre[i+l][j+l]-pre[i+l][j]-pre[i][j+l]+pre[i][j] <= threshold)) {
                    res = l++;
                }
            }
        }
        return res;
    }
}