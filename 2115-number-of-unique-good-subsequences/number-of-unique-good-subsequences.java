
class Solution {
    int MOD = (int) 1e9 + 7;
    private int mod(int num){ return (int) ((num % MOD + MOD) % MOD); }

    public int numberOfUniqueGoodSubsequences(String binary){
        // dp[0] = distinct good subsequences ending with 0
        // dp[1] = distinct good subsequences ending with 1
        int[] dp = new int[2];
        int hasZero = 0;

        for (char c : binary.toCharArray()) {
            int ch = c - '0';
            if(ch == 0) hasZero = 1;

            if(ch == 1){
                // For current character '1':
                // Append 1 to all existing subsequences + create "1"
                dp[1] = mod(dp[0] + dp[1] + 1);
            }else{
                // For current character '0':
                // Append 0 to all existing good subsequences
                dp[0] = mod(dp[0] + dp[1]);
            }
        }

        // "0" alone is handled separately because leading zeros are not allowed.
        // hasZero tracks whether at least one zero exists in the original string.
        return mod(dp[0] + dp[1] + hasZero);
    }
}

// 1                                            -> +1

// 1
// 10                                           -> 0

// '1' 10
// 11  101 '1'                                  -> 1

// '1'  '11'  '101'   10
// '11'  111   1011  '101'  '1'                 -> 1

//  1    11   111   101    1011  '10'
// '10'  110  1110  1010   10110  100           -> 0
