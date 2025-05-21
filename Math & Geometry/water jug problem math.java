public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z>x+y) return false;
        return z%gcd(x,y)==0;
    }
    private int gcd(int a,int b){
        //gcd(a,b)=gcd(b,a%b);
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
