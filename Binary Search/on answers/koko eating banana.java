class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int high=0;
        for(int i:arr){
            high=Math.max(high,i);
        }
        int low=1;
        while(low<=high){
            int mid=high+(low-high)/2;
            if(caneat(arr,mid,h)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean caneat(int[] arr,int k,int h){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int temp=(int)Math.ceil((double)arr[i]/k);
            sum+=temp;
            if(sum>h) return false;
        }
        return true;
    }
}
