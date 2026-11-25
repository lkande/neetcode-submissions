class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < temp.length; i++) {
            int t = temp[i];
            while(!stack.isEmpty() && t > stack.peek()[0]) {
                int[] low = stack.pop();
                res[low[1]] = i - low[1];
            }
            stack.push(new int[]{t, i});
        }
        return res;
    }
}
