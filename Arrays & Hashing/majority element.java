class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int dom=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                dom=nums[i];
                cnt=1;
            }
            else if(nums[i]==dom){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        return dom;
        //veify again if majority element not always exists
        // int freq=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==dom){
        //         freq++;
        //     }
        // }
        // if(freq>nums.length/2) return dom;
        // return -1;
    }
}
