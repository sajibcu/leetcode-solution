class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <=0) return false;
       //  n =;
        while(n!=0 && n%3==0){
            n /=3;
        }
        
        return  n <2;
    }
}