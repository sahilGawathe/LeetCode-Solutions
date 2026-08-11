//import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;
        int min = 0;

        Queue<int[]> pq = new LinkedList<>();

        // Find rotten and fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    pq.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Up, Down, Left, Right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // BFS
        while (!pq.isEmpty() && fresh > 0) {

            int size = pq.size();

            // Process all oranges for this minute
            for (int i = 0; i < size; i++) {

                int[] current = pq.poll();

                int row = current[0];
                int col = current[1];

                // Check four directions
                for (int[] direction : directions) {

                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 &&
                        newRow < rows &&
                        newCol >= 0 &&
                        newCol < cols &&
                        grid[newRow][newCol] == 1) {

                        // Make fresh orange rotten
                        grid[newRow][newCol] = 2;

                        fresh--;

                        pq.offer(new int[]{newRow, newCol});
                    }
                }
            }

            // One minute completed
            min++;
        }

        // Fresh oranges still remain
        if (fresh > 0) {
            return -1;
        }

        return min;
    }
}