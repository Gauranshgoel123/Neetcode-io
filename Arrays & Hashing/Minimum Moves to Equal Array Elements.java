class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i:nums) min=Math.min(min,i);
        int op=0;
        for(int val:nums) op+=(val-min);
        return op;
    }
}
