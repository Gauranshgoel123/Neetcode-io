class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
            String num=Integer.toString(i);
            int n=num.length();
            if(n%2!=0) continue;
            int l=sumstring(num,0,n/2-1);
            int r=sumstring(num,n/2,n-1);
            if(l==r) ans++;
        }
        return ans;
    }
    private int sumstring(String str,int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=str.charAt(i) - '0';
        }
        return sum;
    }
}
