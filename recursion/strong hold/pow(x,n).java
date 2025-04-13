class Solution {
    public double myPow(double x, int n) {
        if(x==1 || n==0) return 1;
        if(x==0) return 0;
        return helper(x,(long)n);
    }
    private double helper(double x,long n){
        if(n==0) return 1;
        if(n<0) return helper(1/x,-n);
        if(n%2==0) return helper(x*x,n/2);
        else{
            return x*helper(x*x,n/2);
        }
    }
}


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
