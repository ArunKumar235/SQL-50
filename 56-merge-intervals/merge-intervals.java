class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        for(int i = 0; i < n; i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            
            while(i+1 < n && intervals[i+1][0] <= r){
                r = Math.max(r, intervals[i+1][1]);
                i++;
            }
            res.add(new int[]{l, r});
        }
        return res.toArray(int[][]::new);
    }
}