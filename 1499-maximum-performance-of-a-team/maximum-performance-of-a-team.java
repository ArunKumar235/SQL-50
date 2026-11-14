class Solution {
    long MOD = (long) 1e9 + 7;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for(int i = 0; i < n; i++){
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);

        long res = 0;
        long speedSum = 0;
        // remove slowest engineer in O(1) - minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            speedSum += engineers[i][0];
            pq.offer(engineers[i][0]);

            if(pq.size() > k) speedSum -= pq.poll();

            res = Math.max(res, speedSum * engineers[i][1]);
        }
        return (int)(res % MOD);
    }
}