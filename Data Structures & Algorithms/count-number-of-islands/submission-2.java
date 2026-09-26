class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ROWS = grid.length, COLS = grid[0].length;
        int islandCount = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    fillIsland(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    void fillIsland(char[][] grid, int row, int col) {
        int ROWS = grid.length, COLS = grid[0].length;
        if (row < 0 || col < 0 || row == ROWS || col == COLS || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        fillIsland(grid, row + 1, col);
        fillIsland(grid, row - 1, col);
        fillIsland(grid, row , col + 1);
        fillIsland(grid, row , col - 1);
    }
}