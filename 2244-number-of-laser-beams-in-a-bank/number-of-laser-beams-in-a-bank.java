class Solution {
    public int numberOfBeams(String[] bank) {
        int lastRowCount = 0;
        int totalBeam = 0;
        for( String s: bank){
            int temp = 0; 
            for( int i=0;i<s.length();i++ ){
                if( s.charAt(i)=='1' ) temp++;
            }
            if( temp > 0 ){
                totalBeam +=lastRowCount*temp;
                lastRowCount = temp;
            }
        }
        
        return totalBeam;
    }
}