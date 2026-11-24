class Solution {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) {
            return false;
        }
        char[] cs = s.toCharArray();
        List<Character> stack = new ArrayList();
        Map<Character, Character> mapping = Map.of(']','[', ')', '(' ,'}' ,'{');
        for(char c : cs) {
            if (mapping.containsKey(c)) {
                char ec = mapping.get(c);
                if (!stack.isEmpty() && stack.get(stack.size()-1) == ec) {
                    stack.remove(stack.size()-1);
                } else {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
