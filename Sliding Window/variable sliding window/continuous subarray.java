class Solution {
    public long continuousSubarrays(int[] nums) {
        int range_max=nums[0];
        int range_min=nums[0];
        long winsize=0;
        int left=0;
        int right=0;
        long count=0;
        for(right=0;right<nums.length;right++){
            range_max=Math.max(range_max,nums[right]);
            range_min=Math.min(range_min,nums[right]);

            if(range_max-range_min > 2){
                winsize=right-left;
                count+=(winsize*(winsize+1))/2;

                left=right;

                range_max=nums[right];
                range_min=nums[right];

                //backtrack of left ptr to count misssed subarrays too
                while(left>0 && Math.abs(nums[right]-nums[left-1]) <= 2){
                    left--;
                    range_max=Math.max(range_max,nums[left]);
                    range_min=Math.min(range_min,nums[left]);
                }
                //subtract double counted subarray 
                if(left<right){
                    winsize=right-left;
                    count-=((winsize)*(winsize+1)/2);
                }
            }        
        }
        winsize=right-left;
        count+=((winsize)*(winsize+1)/2);
        return count;
    }
}
