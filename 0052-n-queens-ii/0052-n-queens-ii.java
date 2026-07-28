class Solution {
    private int count = 0;

    public int totalNQueens(int n) {

        boolean[] cols = new boolean[n];
        boolean[] diagonal = new boolean[2 * n];
        boolean[] antiDiagonal = new boolean[2 * n];

        backtrack(0, n, cols, diagonal, antiDiagonal);

        return count;
    }

    private void backtrack(int row, int n,
                           boolean[] cols,
                           boolean[] diagonal,
                           boolean[] antiDiagonal) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int diag = row - col + n;
            int antiDiag = row + col;

            if (cols[col] || diagonal[diag] || antiDiagonal[antiDiag])
                continue;

            cols[col] = true;
            diagonal[diag] = true;
            antiDiagonal[antiDiag] = true;

            backtrack(row + 1, n, cols, diagonal, antiDiagonal);

            cols[col] = false;
            diagonal[diag] = false;
            antiDiagonal[antiDiag] = false;
        }
    }
}