class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans=0;
        int odd=0,sum=0,even=0;
        for(int i:arr){
            sum+=i;
            if(sum%2!=0){
                ans+=even+1;
                odd++;
            }
            else{
                ans+=odd;
                even++;
            }
        }
        return (int)(ans%(1000000007));
    }
}
