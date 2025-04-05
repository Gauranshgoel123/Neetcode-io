class Solution {
    public int subsetXORSum(int[] nums) {
        return rec(0,0,nums);
    }
    private int rec(int i,int xor,int[] nums){
        if(i==nums.length) return xor;
        int pick=rec(i+1,xor^nums[i],nums);
        int dont=rec(i+1,xor,nums);
        return pick+dont;
    }
}
