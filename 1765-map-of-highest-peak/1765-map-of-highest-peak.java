class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        int[][] height = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // Initialize answer matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int x = curr[0];
            int y = curr[1];

            for (int[] dir : directions) {

                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows &&
                    newY >= 0 && newY < cols &&
                    height[newX][newY] == -1) {

                    height[newX][newY] = height[x][y] + 1;

                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return height;
    }
}