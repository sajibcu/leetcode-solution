class Solution {
    Integer[][] mem;
    public int minimumTotal(List<List<Integer>> triangle) {
        mem = new Integer[triangle.size()+1][triangle.size()+1];
        return getMin(0,0,triangle);
    }

    public int getMin(int l, int i,List<List<Integer>> t) {
        if(l >= t.size()-1) return t.get(l).get(i);

        if(mem[l][i] != null) return mem[l][i];
        
        List<Integer> row = t.get(l);
        if( i >= row.size() ) return Integer.MAX_VALUE;
        int minimum =  row.get(i) + Math.min( getMin(l+1,i,t), getMin(l+1,i+1,t) );
        return mem[l][i] = minimum;
    }
}