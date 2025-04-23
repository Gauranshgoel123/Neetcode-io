class Solution {
    public int countLargestGroup(int n) {
        int[] count=new int[37];
        int ans=0;
        int maxcnt=0;
        for(int i=1;i<=n;i++){
            int sum=0;
            int orig=i;
            while(orig>0){
                sum+=orig%10;
                orig/=10;
            }
            count[sum]++;
            if(count[sum]>maxcnt){
                maxcnt=count[sum];
                ans=1;
            }
            else if(count[sum]==maxcnt){
                ans++;
            }
        }
        return ans;
    }
}


class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxcnt=0;
        for(int i=1;i<=n;i++){
            int sum=sumofdig(i);
            int count=map.getOrDefault(sum,0)+1;
            map.put(sum,count);
            maxcnt=Math.max(maxcnt,count);
        }
        int cnt=0;
        for(int val:map.values()){
            if(maxcnt==val) cnt++;
        }
        return cnt;
    }
    private int sumofdig(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num=num/10;
        }
        return ans;
    }
}
