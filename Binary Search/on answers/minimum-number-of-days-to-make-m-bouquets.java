class Solution {
    public int minDays(int[] arr, int m, int k) {
        if(arr.length<(long)m*k) return -1;
        int low=0;
        int high=0;
        for(int i=0;i<arr.length;i++){
            low=Math.min(low,arr[i]);
            high=Math.max(high,arr[i]);
        }
        while(low<=high){
            int mid=high+(low-high)/2;
            if(!possible(arr,mid,m,k)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    private boolean possible(int[] arr,int day, int m,int k){
        int bloomed=0; 
        int noofb=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                bloomed++;
            }
            else{
                noofb+=(bloomed/k);
                bloomed=0;
            }
        }
        noofb+=(bloomed/k);
        return noofb>=m;
    }
}
