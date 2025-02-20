class Solution {
    
    public String findDifferentBinaryString(String[] nums) {
        int l = nums.length;
        boolean[] isExist= new boolean[l+2];
        for(int i=0;i<nums.length;i++) {
            int temp = Integer.parseInt(nums[i],2);
            if( temp <= l ){
                isExist[temp] = true;
            }

        }
        for(int i=0;i<l;i++) {
            if(!isExist[i]) {
                return makeBinary(i,nums[0].length());
            }

        }
        return makeBinary(l,nums[0].length() );
        
    }

    public String makeBinary(int n, int length) {
        String binary = Integer.toBinaryString(n);
        return String.format("%" + length + "s", binary).replace(' ', '0'); // Pad with zeros
    }
}