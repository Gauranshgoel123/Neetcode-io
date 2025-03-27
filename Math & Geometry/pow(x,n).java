class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1) return 1;
        if(x==0) return 0;
        double res=helper(x,Math.abs((long)n));
        return (res<0) ? 1/res : res;
    }
    private double helper(double x,long n){
        if(n==0) return 1;
        double half=helper(x,n/2);
        return (n%2==0) ? half*half : x*half*half;
    }
}


//O(logN) TC optimal using recursion

// class Solution {
//     public double myPow(double x, int n) {
//         if(x==1 || n==0) return 1;
//         double ans=1;
//         if(n<0){
//             x=1/x;
//             n*=-1;  
//         }
//         while(n>0){
//             ans*=x;
//             n--;
//         }
//         return ans;
//     }
// }
