class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans=-1;
        int low=1;
        int high=max(nums);
        while(low<=high){
            int mid=high+(low-high)/2;
            if(sumofd(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private int max(int[] arr){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>ans){
                ans=arr[i];
            }
        }
        return ans;
    }
    private int sumofd(int[] arr,int div){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=Math.ceil((double)arr[i]/(double)div);
        }
        return sum;
    }
}
