class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int res=nums[0];
        while(l<=r){

            //base condition (sorted)
            if(nums[l]<nums[r]){
                res=Math.min(res,nums[l]);
                break;
            }

            int m=l+(r-l)/2;
            res=Math.min(res,nums[m]);
            if(nums[m]>=nums[l]){
                //search right 
                l=m+1;
            }
            else{
                //search left
                r=m-1;
            }
        }
        return res;
    }
}
