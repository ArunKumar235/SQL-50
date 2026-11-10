class Solution {
    String s;
    String t;
    int[][] dp;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        int slen = s.length();
        int tlen = t.length();

        this.dp = new int[slen][tlen];
        for(int[] row: dp) Arrays.fill(row, -1);

        return func(slen-1, tlen-1);
    }

    private int func(int i, int j){
        if(j == -1) return 1;
        if(i == -1) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        int res = 0;
        
        if(s.charAt(i) == t.charAt(j)) res = func(i-1, j-1) + func(i-1, j);
        else res = func(i-1, j);

        return dp[i][j] = res;
    }
}