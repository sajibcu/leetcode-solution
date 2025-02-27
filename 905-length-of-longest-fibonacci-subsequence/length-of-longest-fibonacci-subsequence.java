class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> index = new HashSet<>();
        for(int n: arr) index.add(n);

        int ans = 0;
        for(int i=0;i<arr.length; i++) {
            for(int j = i+1;j<arr.length;j++) {
                int temp = 2;
                int sum = arr[i] + arr[j];
                int a = arr[i], b = arr[j];
                while( index.contains(a+b) ) {
                    temp ++;
                    int c = a+b;
                    a = b;
                    b = c;
                }
                ans = Math.max(temp, ans);
            }
        }
        return ans > 2 ? ans: 0;
    }
}