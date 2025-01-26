class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<=3){
            return helper(nums);
        }    
        return Math.max(robb(nums,0,n-2),robb(nums,1,n-1));
    }
    private int helper(int[] nums){
        int ans=0;
        for(int i:nums){
            ans=Math.max(ans,i);
        }
        return ans;
    }
    private int robb(int[] nums, int start,int end){
        int n=end-start+1;
        int[] dp=new int[n];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i+start],dp[i-1]);
        }
        return dp[n-1];
    }
}
