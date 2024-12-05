class Solution {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        int offset=1;
        for(int i=1;i<=n;i++){
            if(offset*2==i){
                offset=i;
            }
            dp[i]=1+dp[i-offset];
        }
        return dp;
    }
}


class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=Integer.bitCount(i);
        }
        return ans;
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=helper(i);
        }
        return ans;
    }
    private int helper(int n){
        int ans=0;
        while(n>0){
            if((n&1)==1) ans++;
            n>>=1;
        }
        return ans;
    }
}
