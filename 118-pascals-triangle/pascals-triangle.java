class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        pascal.add(List.of(1));
        while( numRows > 1) {
            numRows--;
            List<Integer> top = pascal.get(pascal.size()-1);

            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int i=1;i<top.size(); i++) {
                row.add(top.get(i) + top.get(i-1));
            }
            row.add(1);
            pascal.add(row);
        }

        return pascal;

    }
}