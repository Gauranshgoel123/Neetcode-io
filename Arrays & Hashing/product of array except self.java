class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int prod=1,zerocount=0;
        for(int i:nums){
            if(i!=0){
                prod*=i;
            }
            else{
                zerocount++;
            }
        }
        if(zerocount>1){
            return new int[nums.length];
        }
        for(int i=0;i<nums.length;i++){
            if(zerocount>0){
                ans[i]=(nums[i]==0)?prod:0;
            }
            else{
                ans[i]=prod/nums[i];   
            }
        }
        return ans;
    }
}
