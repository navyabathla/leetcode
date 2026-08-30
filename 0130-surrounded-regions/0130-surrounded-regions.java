class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Top and bottom rows
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // Left and right columns
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        // Convert remaining O's to X
        // Convert safe # back to O
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {

        int m = board.length;
        int n = board[0].length;

        // Outside grid or not an O
        if (r < 0 || r >= m || c < 0 || c >= n
                || board[r][c] != 'O') {
            return;
        }

        // Mark as safe
        board[r][c] = '#';

        // Up
        dfs(board, r - 1, c);

        // Down
        dfs(board, r + 1, c);

        // Left
        dfs(board, r, c - 1);

        // Right
        dfs(board, r, c + 1);
    }
}