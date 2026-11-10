class Solution {
    int MOD = (int) 1e9 + 7;
    private int mod(int num){ return (int)((num % MOD + MOD)%MOD); }

    public int distinctSubseqII(String s) {
        // to track the number of subseq having dp[i] as the last char
        int[] dp = new int[26];

        int total = 0;
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i) - 'a';
            // number of new subseq possible (appending char to existing + char itself)
            int newSubSeq = mod(total + 1);
            
            // number of new subseq already present in existing total            
            int duplicates = dp[ch];
            
            // count of subseq having ch as the last char
            dp[ch] = newSubSeq;
            
            total = mod((total + newSubSeq) - duplicates);
        }
        return total;
    }
}

// a b ab                                                   -> ab

// a  b  ab
// ac bc abc c                                              -> +c 

//  a   'b'  'ab'  ac   bc   abc   c
// 'ab'  bb   abb  acb  bcb  abcb  cb  'b'                  -> +b