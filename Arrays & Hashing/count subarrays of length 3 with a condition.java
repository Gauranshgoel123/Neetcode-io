class Solution {
    public int countSubarrays(int[] nums) {
        int cnt=0;
        for(int i=0;i<nums.length-2;i++){
            int sum=nums[i]+nums[i+2];
            if(nums[i+1]==sum*2) cnt++;
        }   
        return cnt;
    }
}


class Solution {
    public int countSubarrays(int[] nums) {
        if(nums.length<3) return 0;
        int cnt=0,i=0,j=2;
        while(j<nums.length){
            double lsum= (double)nums[i]+(double)nums[j];
            double rsum=(double)nums[(i+j)/2]/2;
            if(lsum==rsum) cnt++;
            i++;
            j++;
        }       
        return cnt;
    }
}
