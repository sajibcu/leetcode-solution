class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {


        List<int[]> ans = new ArrayList<>();

        int i =0, j= 0, l1 = nums1.length, l2 = nums2.length;
        while( i < l1 && j< l2 ) {
             if( nums1[i][0] == nums2[j][0]) {
                ans.add( new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]} );
                i++;
                j++;
             }else if(nums1[i][0] < nums2[j][0] ) {
                ans.add( nums1[i++] );
             }else {
                ans.add( nums2[j++]);
             }
        }

        // add remaing item
        while( i < l1 ) ans.add( nums1[i++] );
        while( j < l2 ) ans.add( nums2[j++]);

        return ans.toArray(new int[0][]);
    }
}