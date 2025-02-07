class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]==target) return m;
            else if(nums[m]>=nums[l]){
                //left part is sorted

                //check if in left part
                if(target>=nums[l] && target<=nums[m]){
                    //trim right part
                    r=m-1;
                }
                else{
                    //trim left part
                    l=m+1;
                }
            }
            else{
                //right part is sorted

                //check if in right part
                if(target>=nums[m] && target<=nums[r]){
                    //trim left part
                    l=m+1;
                }
                else{
                    //trim right part
                    r=m-1;
                }
            }
        }
        return -1;

    }
}
