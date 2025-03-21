class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int l=0;
        for(int i=0;i<arr.length;i++){
            l=Math.max(arr[i],l);
        }
        int h=sumofall(arr);
        while(l<=h){
            int m=(l+h)/2;
            if(possible(arr,m,days)){
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return l;
    }
    private int sumofall(int[] arr){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }
    private boolean possible(int[] arr,int cap, int days){
        int sum=arr[0];
        int cnt=0;
        for(int i=1;i<arr.length;i++){
            if(sum+arr[i]<=cap){
                sum+=arr[i];
            }
            else{
                cnt++;
                sum=arr[i];  
            }
        }
        cnt++;
        if(cnt>days) return false;
        return true;
    }
}

