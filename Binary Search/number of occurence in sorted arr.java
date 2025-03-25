class Solution {
    int countFreq(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        //binary search to find first occurence
        int start=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                start=m;
                r=m-1;
            }
            else if(nums[m]>target){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        
        if(start==-1) return 0;

        //reset pointers
        l=0;
        r=n-1;

        //binary search to find last occurence
        int last=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                last=m;
                l=m+1;
            }
            else if(nums[m]>target){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        if(last==-1) return 0;
        if(last==start) return 1;
        return last-start+1;
        
    }
}
