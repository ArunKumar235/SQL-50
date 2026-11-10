class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;

        // maximum subsequence sum till i
        int[] dp = new int[n];

        // helps us find max valid subsequence sum till every index
        Deque<Integer> decDQ = new ArrayDeque<>();

        int res = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            // expired - remove values before k positions
            while(!decDQ.isEmpty() && i - decDQ.peekFirst() > k){
                decDQ.pollFirst();
            }

            // nums[i] + best previous sequence
            dp[i] = nums[i];
            if(!decDQ.isEmpty()) dp[i] += Math.max(0, dp[decDQ.peekFirst()]);

            res = Math.max(res, dp[i]);

            // maintaining decreasing order
            while(!decDQ.isEmpty() && dp[decDQ.peekLast()] < dp[i]){
                decDQ.pollLast();
            }
            decDQ.offerLast(i);
        }
        return res;    
    }
}