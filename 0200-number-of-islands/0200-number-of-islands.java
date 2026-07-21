class Solution {
   private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private void dfs(char[][] grid, int row, int col) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {

                    islands++;

                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }
}