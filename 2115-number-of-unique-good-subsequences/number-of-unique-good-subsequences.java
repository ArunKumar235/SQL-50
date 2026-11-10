
class Solution {
    int MOD = (int) 1e9 + 7;
    private int mod(int num){ return (int) ((num % MOD + MOD) % MOD); }

    public int numberOfUniqueGoodSubsequences(String binary){
        int has0 = 0;
        // distinct good subsequences ending with 0
        int end0 = 0;
        // distinct good subsequences ending with 1
        int end1 = 0;
        
        for (char ch : binary.toCharArray()) {
            if(ch == '1'){
                // For current character '1':
                // Append 1 to all existing subsequences + create "1"
                end1 = mod(end0 + end1 + 1);
            }else{
                has0 = 1;
                // For current character '0':
                // Append 0 to all existing good subsequences
                end0 = mod(end0 + end1);
            }
        }

        // "0" alone is handled separately because leading zeros are not allowed.
        // hasZero tracks whether at least one zero exists in the original string.
        return mod(end0 + end1 + has0);
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
