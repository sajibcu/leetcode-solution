class Solution {
    public int[] sumZero(int n) {
        int first = n/2;
        int[] ans = new int[n];
        for(int i=0;i<first;i++) {
            ans[i] = i+1;
            ans[n-i-1] = (-1)*ans[i];
        }
        return ans;
    }
}