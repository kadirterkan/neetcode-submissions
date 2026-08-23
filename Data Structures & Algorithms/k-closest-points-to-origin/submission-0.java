class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return null;
        }
        int[][] sorted = quickSort(points, 0, points.length - 1);

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        return res;
    }

    int[][] quickSort(int[][] points, int lo, int hi) {
        if (hi - lo + 1 <= 1) {
            return points;
        }

        int[] pivot = points[hi];
        int left = lo;

        for (int i = left; i < hi; i++) {
            double pivDistance = distance(pivot);
            if (distance(points[i]) <= pivDistance) {
                int[] temp = points[i];
                points[i] = points[left];
                points[left] = temp;
                left++;
            }
        }

        points[hi] = points[left];
        points[left] = pivot;

        quickSort(points, lo, left - 1);
        
        quickSort(points, left + 1, hi);

        return points;
    }

    double distance(int[] a) {
        return Math.sqrt(a[0]*a[0] + a[1]*a[1]);
    }
}
