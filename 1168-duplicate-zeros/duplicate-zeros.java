class Solution {
    public void duplicateZeros(int[] arr) {
        int[] help = new int[arr.length];
        int i=0;
        int j=0;
        while( j < arr.length ) {
            if(arr[i] == 0 ){ 
                help[j++]= 0;
                if(j< arr.length )
                help[j++]= 0;
            }else {
                help[j]= arr[i];
                j++;
            }
            
                i++;
        }
        for(i=0;i<arr.length;i++){
            arr[i] = help[i];
        }
        
    }
}