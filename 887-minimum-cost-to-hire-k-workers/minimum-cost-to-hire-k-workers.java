class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        int[][] workers = new int[n][2];
        for(int i = 0; i < n; i++){
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
        }
        // sort by wage/quality ratio in increasing order
        Arrays.sort(workers, 
            (a, b) -> Double.compare((1.0*a[1])/a[0], (1.0*b[1])/b[0])
        );

        // remove highestQuality person in O(1)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        double res = Double.MAX_VALUE;
        double qualitySum = 0;
        for(int i = 0; i < n; i++){
            qualitySum += workers[i][0];
            pq.offer(workers[i][0]);

            double ratio = (1.0*workers[i][1])/workers[i][0];

            if(pq.size() >k) qualitySum -= pq.poll();
            if(pq.size() == k) res = Math.min(res, ratio * qualitySum);
        }
        return res;
    }
}

// 50 30 70
// 20  5 10
// 2.5 6  7 -> sort by ratio