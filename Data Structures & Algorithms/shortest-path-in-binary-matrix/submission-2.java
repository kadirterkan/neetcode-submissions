class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int ROWS = grid.length, COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[2]);
        visit[0][0] = 1;

        int length = 1;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];
                if (r == ROWS - 1 && c == COLS - 1 && grid[r][c] == 0) {
                    return length;
                }
                if (grid[r][c] == 1) {
                    continue;
                }
                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c},
                {r + 1, c + 1}, {r - 1, c - 1}, {r + 1, c - 1}, {r - 1, c + 1}};
                for (int j = 0; j < 8 ; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(neighbors[j]);
                    visit[newR][newC] = 1;
                }
            }
            length++;
        }
        return -1;
    }
}