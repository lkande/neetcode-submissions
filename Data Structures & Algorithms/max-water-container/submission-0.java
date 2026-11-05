class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int left = 0;
        int right = heights.length-1;
        int max = 0;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int volume = height * width;
            if (volume > max) {
                max = volume;
            }
            if (heights[left] < heights[right]) {
                left ++;
            } else {
                right--;
            }

        }
        return max;
    }
}
