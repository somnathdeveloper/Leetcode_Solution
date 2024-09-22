// Algo used: DFS
// Intuation: First will will traverse all corner's O and go in side the cells where the O's are connected with the corner ones via DFS
// So we are doing we are passsing all 4 border sepreatley to DFS, which will traverse and mark all the between O's whic are connected to the corner as true
// At last we will traverse all the 'O' which are in the middle which are not visited and make it as 'X' as per the questtion

// TC: O NxM , SC: O NxM
class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, +1, 0, -1 };
        boolean[][] visited = new boolean[n][m];

        // Traversing all 4 corners via DFS
        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && grid[i][0] == 'O') {
                dfs(i, 0, delrow, delcol, visited, grid);
            }
            if (!visited[i][m - 1] && grid[i][m - 1] == 'O') {
                dfs(i, m - 1, delrow, delcol, visited, grid);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!visited[0][i] && grid[0][i] == 'O') {
                dfs(0, i, delrow, delcol, visited, grid);
            }
            if (!visited[n - 1][i] && grid[n - 1][i] == 'O') {
                dfs(n - 1, i, delrow, delcol, visited, grid);
            }
        }

        // Marking the unvisted '0's as 'X' that will be only in between bcz all the
        // corner '0' and the 'O' which are attached with 'O' will me already be marked
        // as true via DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    // DFS
    public void dfs(int row, int col, int[] delrow, int[] delcol, boolean[][] visited, char[][] grid) {
        visited[row][col] = true; // marke true as soon as we start
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) { // traversing 4 ways, up,right,down,left (neighbours)
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && !visited[nrow][ncol] && grid[nrow][ncol] == 'O') {
                dfs(nrow, ncol, delrow, delcol, visited, grid); // passing the neighbours i.r all 4 direction of curr
                                                                // cell to the DFS if it statisfies the condition so it
                                                                // will be marked true as soon as recc calls DFS
            }
        }
    }
}