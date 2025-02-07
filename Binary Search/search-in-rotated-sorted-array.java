class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int m = l+(r-l)/2;
            if(nums[m]>nums[r]){
                l=m+1;
            }else{
                r=m;
            }
        }
        int pivot=l;
        int a=binary(nums,0,pivot-1,target);
        if(a==-1){
            int b=binary(nums,pivot,nums.length-1,target);
            return b;
        }
        return a;
    }
    private int binary(int[] nums,int l,int r,int target){
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                return m;
            }
            else if(nums[m]>target){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return -1;
    }
}
