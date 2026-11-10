class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        Set<String> dict = new HashSet<>();
        for(String str: wordDict) dict.add(str);

        return func(0, s, dp, dict) == 1;
    }

    private int func(int l, String s, int[] dp, Set<String> dict){
        if(l == s.length()) return 1;

        if(dp[l] != -1) return dp[l];

        StringBuilder sb = new StringBuilder("");
        for(int k = l; k < s.length(); k++){
            sb.append(s.charAt(k));

            if(dict.contains(sb.toString())){
                if(func(k+1, s, dp, dict) == 1){
                    return dp[l] = 1;
                }
            }
        }
        return dp[l] = 0;
    }
}