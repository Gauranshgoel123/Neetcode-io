class Solution {
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int sq=i*i;
            String str=Integer.toString(sq);
            if(candivide(str,i)){
                ans+=sq;
            }
        }
        return ans;
    }
    private boolean candivide(String str,int target){
        if(str.isEmpty() && target==0){
            return true;
        }
        if(target<0) return false;
        for(int i=0;i<str.length();i++){
            String left=str.substring(0,i+1);
            String right=str.substring(i+1,str.length());
            int leftnum=Integer.parseInt(left);
            if(candivide(right,target-leftnum)){
                return true;
            }
        }
        return false;
    }
}
