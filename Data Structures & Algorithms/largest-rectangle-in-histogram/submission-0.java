public class Solution {
    public int largestRectangleArea(int[] heights) {
        int l = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxH = 0;
        for (int i = 0; i <= l; i++) {
            while(!stack.isEmpty() && (i == l || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxH = Math.max(maxH, height * width);
            }
            stack.push(i);
        }
        return maxH;
    }
}