class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[] diagonal = new int[m*n];
        int indx = 0;

        for(int d=0;d<m+n-1;d++) {
            List<Integer> diaRow = new ArrayList<>();
            int row = d < m ? d : m-1;
            int col = d< m ? 0 : d - m+1;
            //System.out.println(row+" col "+ col);
            while(row >= 0 && col < n ) {
                diaRow.add(mat[row][col]);
                row --;
                col++;
            }
            // System.out.println(diaRow);
            if(d%2 == 1) {
                Collections.reverse(diaRow);
            }

            for(int a: diaRow) {
                diagonal[indx++] = a;
            }

        }

        return diagonal;
    }
}