class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> substring = new LinkedHashSet<>();
        int max = 0;
        int left = 0;
        Character c = ' ';
        for (int right  = 0; right < s.length(); right++) {
            c = s.charAt(right);
            while (substring.contains(c)) {
                substring.remove(s.charAt(left++));
            }
            substring.add(c);
            max = Math.max(max, substring.size());
        }
        return max;
    }
}
