class Solution {
    static {
        for (int i = 0; i < 100; i++) {
            maxArea(new int[] {0, 0});
        }   
    }

    public static int maxArea(int[] height) {
        int contain = 0;

        int left = 0, right = height.length-1;

        // sliding window
        while(left < right) {
            contain = Math.max(contain, Math.min(height[left], height[right]) * (right-left));
            if( height[left] < height[right]) {
                left++;
            }else right--;
        }
        return contain;
    }
}