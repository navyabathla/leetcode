class Solution {
    public int[][] updateMatrix(int[][] mat) {
         int rows = mat.length;
        int cols = mat[0].length;

        int[][] distance = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // Push all 0s into the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
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
                    !visited[newX][newY]) {

                    distance[newX][newY] = distance[x][y] + 1;

                    visited[newX][newY] = true;

                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return distance;
    }
}