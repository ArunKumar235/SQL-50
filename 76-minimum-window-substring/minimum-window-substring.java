class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch: t.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        String res = s+s;

        int letters = freq.size();

        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char chR = s.charAt(r);
            if(!freq.containsKey(chR)) continue;

            freq.put(chR, freq.get(chR)-1);
            if(freq.get(chR) == 0) letters--;

            while(letters == 0){
                if(res.length() > (r - l + 1)){
                    res = s.substring(l, r+1);
                }
                char chL = s.charAt(l);
                if(!freq.containsKey(chL)){
                    l++;
                    continue;
                }

                if(freq.get(chL) == 0) letters++;
                freq.put(chL, freq.get(chL)+1);
                l++;
            }

        }
        return res.length() > s.length() ? "" : res; 
    }
}