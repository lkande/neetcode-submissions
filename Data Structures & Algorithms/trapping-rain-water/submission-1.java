class Solution {
    public int trap(int[] height) {
        if (height == null || height.length<2) {
            return 0;
        }
        print(height);
        int left = 0;
        int right = height.length-1;
        int lmax = height[left];
        int rmax = height[right];
        int result = 0;
        System.out.println("Starting...");
        while (left < right) {
            if (lmax < rmax) {
                left ++;
                lmax = Math.max(lmax, height[left]);
                result += lmax - height[left];
                //System.out
            } else {
                right --;
                rmax = Math.max(rmax, height[right]);
                result += rmax - height[right];
            }
        }
        System.out.println("Result: " + result);
        return result;
    }

    void print(int[] trap) {
        System.out.println("");
        System.out.print("(");
        for(int i : trap) {
            System.out.print(i + ",");
        }
        System.out.print(")");
    }

}
