class Solution {
    public int maxDistance(int[][] grid) {
         int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int land = 0;
        int water = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    land++;
                } else {
                    water++;
                }
            }
        }

        if (land == 0 || water == 0) {
            return -1;
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int distance = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            distance++;

            while (size-- > 0) {

                int[] curr = queue.poll();

                int x = curr[0];
                int y = curr[1];

                for (int[] dir : directions) {

                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows &&
                        newY >= 0 && newY < cols &&
                        grid[newX][newY] == 0) {

                        grid[newX][newY] = 1;

                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return distance;
    }
}