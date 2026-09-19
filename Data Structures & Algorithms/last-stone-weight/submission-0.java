class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < stones.length ; i++) {
            heap.offer(stones[i]);
        }

        while (heap.size() > 1) {
            int first = heap.poll();
            int sec = heap.poll();
            int diff = Math.abs(first - sec);
            heap.offer(diff);
        }
        return heap.poll();
    }
}
