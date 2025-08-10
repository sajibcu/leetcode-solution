class Solution {
    public boolean reorderedPowerOf2(int n) {

        List<String> all = new ArrayList<>();
        String s = String.valueOf(n);
        permute(s.toCharArray(),0,all);
        for(String num : all) {
            if( num.charAt(0)=='0') continue;
            if(isPowerOf2(Integer.parseInt(num))) return true;

        }
        return false;
    }

    public void permute(char[] arr,int index, List<String> result) {
        if( index == arr.length) {
            result.add(new String(arr));
            return;
        }

        Set<Character> used = new HashSet<>();

        for(int i =index; i< arr.length; i++) {
            if(used.contains(arr[i])) continue;
            used.add(arr[i]);
            swap(arr, index, i);
            permute(arr,index+1,result);
            swap(arr, i, index);
        }

    }

    public void swap( char[] ar, int i,int j) {
        char c = ar[i];
        ar[i] = ar[j];
        ar[j] = c;
    }

    public boolean isPowerOf2(int n) {
        for(int i=0;i<32;i++) {
            if( (1<<i) == n) return true;
        }
        return false;
    }
}