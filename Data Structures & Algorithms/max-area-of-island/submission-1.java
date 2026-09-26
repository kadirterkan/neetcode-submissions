class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ROWS = grid.length, COLS = grid[0].length;
        int max = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    int res = fillIsland(grid, r, c);
                    if (res > max) max = res;
                }
            }
        }
        return max;
    }

    int fillIsland(int[][] grid, int row, int col) {
        int ROWS = grid.length, COLS = grid[0].length;
        if (row < 0 || col < 0 || row == ROWS || col == COLS || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int count = 1;

        count += fillIsland(grid, row + 1, col);
        count += fillIsland(grid, row - 1, col);
        count += fillIsland(grid, row , col + 1);
        count += fillIsland(grid, row , col - 1);
        return count;
    }
}
