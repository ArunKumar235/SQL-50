class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int maxLen = a+b+c;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<maxLen){
            if(a>0 && aCount!=2 && ((a>=b && a>=c) || (bCount==2 || cCount==2))){
                sb.append('a');
                aCount++;
                a--;
                bCount = 0;
                cCount = 0;
            }else if(b>0 && bCount!=2 && ((b>=a && b>=c) || (aCount==2 || cCount==2))){
                sb.append('b');
                bCount++;
                b--;
                aCount= 0;
                cCount = 0;
            }else if(c>0 && cCount!=2 && ((c>=a && c>=b) || (aCount==2 || bCount==2))){
                sb.append('c');
                cCount++;
                c--;
                aCount = 0;
                bCount = 0;
            }
            i++;
        }
        return sb.toString();
    }
}