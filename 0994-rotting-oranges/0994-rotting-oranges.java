class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Add all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : directions) {

                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows &&
                        newY >= 0 && newY < cols &&
                        grid[newX][newY] == 1) {

                        grid[newX][newY] = 2;
                        fresh--;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }

            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}