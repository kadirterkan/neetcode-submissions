class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) return null;
        int rows = image.length, cols = image[0].length;
        int source = image[sr][sc];
        int[][] visit = new int[rows][cols];

        fill(image, sr, sc, source, color, visit);

        return image;
    }

    void fill(int[][] image, int r, int c, int source, int color, int[][] visit) {
        int rows = image.length, cols = image[0].length;
        if (r < 0 || c < 0 || r > rows - 1 || c > cols - 1 
            || visit[r][c] == 1 || image[r][c] != source) {
            return;
        }
        visit[r][c] = 1;
        image[r][c] = color;

        fill(image, r - 1, c, source, color, visit);
        fill(image, r + 1, c, source, color, visit);
        fill(image, r, c - 1, source, color, visit);
        fill(image, r, c + 1, source, color, visit);
    }
}