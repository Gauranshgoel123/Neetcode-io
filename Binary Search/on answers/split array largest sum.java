class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return -1;
        int low=0;
        int high=0;
        for(int i:nums){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            int m=high+(low-high)/2;
            if(countsplit(nums,m)>k){
                low=m+1;
            }
            else{
                high=m-1;
            }
        }
        return low;
    }
    private int countsplit(int[] arr,int maxsum){
        int currsum=0;
        int split=1;
        for(int i=0;i<arr.length;i++){
            if(currsum+arr[i]<=maxsum){
                currsum+=arr[i];
            }
            else{
                split++;
                currsum=arr[i];
            }
        }
        return split;
    }
}
