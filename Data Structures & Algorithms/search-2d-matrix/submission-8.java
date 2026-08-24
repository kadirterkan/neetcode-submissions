class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int lo = 0, hi = matrix.length - 1;
        int midd = 0;

        while (lo <= hi) {
            midd = (lo + hi) / 2;
            int value = matrix[midd][0];
            if (value == target) {
                return true;
            } else if (value < target) {
                lo = midd + 1;
            } else {
                hi = midd - 1;
            }
        }
        
        lo = 0;
        int last = matrix[midd][0] < target ?  midd : midd - 1;
        if (last < 0) return false;
        hi = matrix[last].length - 1;
        while (lo <= hi) {
            midd = (lo + hi) / 2;
            int value = matrix[last][midd];
            if (value == target) {
                return true;
            } else if (value < target) {
                lo = midd + 1;
            } else {
                hi = midd - 1;
            }
        }
        return false;
    }
}
