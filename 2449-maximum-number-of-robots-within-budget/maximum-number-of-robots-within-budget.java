class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;

        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0;
        long sum = 0;
        int ans = 0;

        for(int r = 0; r < n; r++){
            //maintain decreasing order
            while(!dq.isEmpty() && chargeTimes[r] >= chargeTimes[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(r);

            sum += runningCosts[r];

            while(!dq.isEmpty()){
                int k = r - l + 1;
                long total = chargeTimes[dq.peekFirst()] + k * sum;

                if(total <= budget){
                    ans = Math.max(ans, k);
                    break;
                }

                if(dq.peekFirst() == l) dq.pollFirst();

                sum -= runningCosts[l];
                l++;
            }
        }
        return ans;
    }
}