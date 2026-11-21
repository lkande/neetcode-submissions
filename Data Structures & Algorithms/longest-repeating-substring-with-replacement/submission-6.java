class Solution {
    public int characterReplacement(String s, int k) {
       if (s == null || s.isEmpty()) {
        return 0;
       }
       /*
        freq
        max
        itr r < s.len
        c = s.char r
        freq.add c+1
        freq = freq(c)
        sub = r-l+1
        if (sub <= freq + k)
            r++
            max = max(r-l+1, max)
        else 
            r++
            l++
            lc = char(l)
            freq lc-1
    */
        Map<Character, Integer> freq = new HashMap<>();
        int max = 0;
        int fr = 0;
        int l = 0; 
        int r = 0;
        while (r<s.length()) {
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0)+1);
            fr = Math.max(fr, freq.get(c));
            int sublen = r-l+1;
            if (sublen <= (fr + k)) {
                max = Math.max(sublen, max);
            } else {
                char lc = s.charAt(l);
                freq.put(lc, freq.get(lc)-1);
                l++;
            }
            r++;        
        }    
        return max;
    }
       /*
       maxchar
       result
       l, r
       c char r
       map freq char char+1
            if (maxchar != c) 
            map.get c
            if (maxchar <= c)
                machar = c
        maxl map.get maxchar
        if k <= r-l+1 
         result = max of result  r-l+1
       */
/*        char maxChar;
        int result = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> freq = new HashMap<>();
        
       int max = 0;
       for (int i = 0; i < s.length(); i++ ) {
            int mis = 0;
            Character c = s.charAt(i);
            int right = i+1;
            while (mis <= k && right < s.length()) {
                Character newC = s.charAt(right);
                if (c != newC) {
                    mis++;
                } 
                if(mis<=k) {
                    max = Math.max(max, right-i+1);
                }
                right++;
            }
       }
       return max;
    }
    */
}
