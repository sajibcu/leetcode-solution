class Solution {
    public boolean rotateString(String s, String goal) {
        String rotate =s+s;
        return s.length() == goal.length() && rotate.contains(goal);
        
    }
}