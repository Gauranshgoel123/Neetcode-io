class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n=arr.length;
        int m=arr[0].length;
        int index=-1;
        int cntmax=0;
        for(int i=0;i<n;i++){
            int cntones=m-firstocc(arr[i],1);
            if(cntones==m+1) cntones=0;
            if(cntones>cntmax){
                cntmax=cntones;
                index=i;
            }
        }
        return index;
    }
    private int firstocc(int[] arr,int target){
        int l=0;
        int r=arr.length-1;
        int index=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(arr[m]>=target){
                index=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return index;
    }
}
