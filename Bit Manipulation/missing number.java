class Solution {
    public int missingNumber(int[] nums) {
        int xor=nums.length;
        for(int i=0;i<nums.length;i++){
            xor=xor^(i^nums[i]);
        }
        return xor;
    }
}


class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
        int s=0;
        for(int i:nums){
            s+=i;
        }
        return sum-s;
    }
}
