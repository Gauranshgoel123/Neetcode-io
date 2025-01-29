class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[n]=1;
        dp[n-1]=1;
        for(int i=n-2;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
        // int two=1;
        // int one=1;
        // for (int i = 0; i < n - 1; i++) {
        //     int temp = one;
        //     one = one + two;
        //     two = temp;
        // }
        // return one;

        //recursion TLE
        // public class Solution {
        //     public int climbStairs(int n) {
        //         return dfs(n, 0); 
        //     }

        //     public int dfs(int n, int i) {
        //         if (i >= n) return i == n ? 1 : 0;
        //         return dfs(n, i + 1) + dfs(n, i + 2);
        //     }
        // }
    }
}
