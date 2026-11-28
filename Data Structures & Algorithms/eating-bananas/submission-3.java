class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int min = r;
        while (l <= r) {
            int k = (l+r)/2;
            int total = 0;
            for (int pile : piles) {
                total += Math.ceil((double)pile/k);
            }
            if (total <= h) {
                //min = Math.min(min, k);
                min = k;
                r = k-1;
            } else {
                l = k+1;
            }
        }
        return min;
    }
}
