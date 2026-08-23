class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return null;
        }
        quickSort(points, 0, points.length - 1, k - 1);

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        return res;
    }

    private void quickSort(int[][] points, int lo, int hi, int k) {
        while (lo <= hi) {
            int pivotIndex = quickSort(points, lo, hi);

            if (pivotIndex == k) {
                return;
            } else if (pivotIndex > k) {
                hi = pivotIndex - 1;
            } else {
                lo = pivotIndex + 1;
            }
        }
    }

    int quickSort(int[][] points, int lo, int hi) {
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

        return left;
    }

    double distance(int[] a) {
        return Math.sqrt(a[0]*a[0] + a[1]*a[1]);
    }
}
