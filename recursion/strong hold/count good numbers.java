class Solution {
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long mod=1000000007;
        return (int)((helper(5,even,mod)*helper(4,odd,mod))%mod);
    }
    private long helper(long base,long exp,long mod){
        long ans=1;
        while(exp>0){
            if(exp%2==1){
                ans=(ans*base)%mod;
                exp-=1;
            }
            else{
                base=(base*base)%mod;
                exp=exp/2;
            }
        }
        return ans;
    }
}
