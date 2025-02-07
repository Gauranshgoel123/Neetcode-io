class Solution {
    public boolean search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target) return true;
            //for duplicacy
            if(nums[l]==nums[m] && nums[m]==nums[r]){
                l++;
                r--;
                continue; //keep on shrinking the search space
            }
            else if(nums[m]<=nums[r]){
                //in right sorted part
                if(target>=nums[m] && target<=nums[r]){
                    l=m+1;
                }
                else{
                    r=m-1;
                }
            }
            else{
                //in left sorted part
                if(target>=nums[l] && target<=nums[m]){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
        }
        return false;
    }
}
