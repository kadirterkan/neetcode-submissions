class Solution {
    public int orangesRotting(int[][] grid) {
       if (grid == null || grid.length == 0) {
            return -1;
        }

        int ROWS = grid.length, COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    int[] pos = {i, j};
                    queue.add(pos);
                    visit[i][j] = 1;
                }
            }
        }

        int length = 0;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];
                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
                if (grid[r][c] == 0) {
                    return -1;
                }
                for (int j = 0; j < 4 ; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS || visit[newR][newC] == 1 || grid[newR][newC] == 0 || grid[newR][newC] == 2) {
                        continue;
                    }
                    grid[newR][newC] = 2;
                    System.out.println("new R " + newR +"  new C " + newC);
                    queue.add(neighbors[j]);
                    visit[newR][newC] = 1;
                }
            }
            if (!queue.isEmpty()) {
                length++;
            }
            
            System.out.println();
        }
        if (checkIfClear(grid)) {
            return length;
        }
        return -1; 
    }

    boolean checkIfClear(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
