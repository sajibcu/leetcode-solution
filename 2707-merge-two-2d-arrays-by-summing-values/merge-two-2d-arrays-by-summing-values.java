class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        List<int[]> n1 = Arrays.stream(nums1)
        .sorted( (a,b) -> Integer.compare(a[0],b[0]))
        .toList();

        List<int[]> n2 = Arrays.stream(nums2)
        .sorted( (a,b) -> Integer.compare(a[0],b[0]))
        .toList();

        List<int[]> ans = new ArrayList<>();

        int i =0, j= 0, l1 = n1.size(), l2 = n2.size();
        while( i < l1 || j< l2 ) {
            if(i < l1 && j< l2) {
                if( n1.get(i)[0] == n2.get(j)[0] ) {
                    n1.get(i)[1] += n2.get(j)[1];
                    ans.add(n1.get(i));
                    i++;
                    j++;
                }else if( n1.get(i)[0] < n2.get(j)[0] ) {
                    ans.add(n1.get(i++));
                }else {
                    ans.add(n2.get(j++));
                }
            }else if( i < l1) {
                ans.add(n1.get(i++));
            }else {
                ans.add(n2.get(j++));
            }
        }

        return ans.toArray(new int[0][]);
        
    }
}