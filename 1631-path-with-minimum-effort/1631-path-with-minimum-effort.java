class Solution {

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        // Minimum effort required to reach each cell
        int[][] effort = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        // {effort, row, column}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        effort[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentEffort = current[0];
            int r = current[1];
            int c = current[2];

            // If this is an outdated entry
            if (currentEffort > effort[r][c]) {
                continue;
            }

            // We reached destination with minimum effort
            if (r == rows - 1 && c == cols - 1) {
                return currentEffort;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check boundaries
                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }

                // Cost of this particular move
                int difference =
                    Math.abs(heights[r][c] - heights[nr][nc]);

                // Effort of complete path
                int newEffort =
                    Math.max(currentEffort, difference);

                // Found a better path
                if (newEffort < effort[nr][nc]) {

                    effort[nr][nc] = newEffort;

                    pq.add(new int[]{
                        newEffort,
                        nr,
                        nc
                    });
                }
            }
        }

        return 0;
    }
}