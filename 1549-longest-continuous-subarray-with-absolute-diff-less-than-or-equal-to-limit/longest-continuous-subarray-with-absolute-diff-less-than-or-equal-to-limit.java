class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // maintain increasing order
        // used to find the minimum element in current subarray
        Deque<Integer> incDQ = new ArrayDeque<>();
        // maintain decreasing order
        // used to find the maximum element in current subarray
        Deque<Integer> decDQ = new ArrayDeque<>();
        
        int len = 0;
        int l = 0;

        for(int r = 0; r < nums.length; r++){
            while(!incDQ.isEmpty() && nums[r] < nums[incDQ.peekLast()]){
                incDQ.pollLast();
            }

            while(!decDQ.isEmpty() && nums[r] > nums[decDQ.peekLast()]){
                decDQ.pollLast();
            }

            incDQ.offerLast(r);
            decDQ.offerLast(r);

            // shrink window when max - min > limit
            while(nums[decDQ.peekFirst()] - nums[incDQ.peekFirst()] > limit){
                if(incDQ.peekFirst() == l) incDQ.pollFirst();
                if(decDQ.peekFirst() == l) decDQ.pollFirst();

                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}