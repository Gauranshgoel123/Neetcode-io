class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            int digsum=digsum(nums[i]);
            if(map.containsKey(digsum)){
                int v=map.get(digsum);
                int sum=v+nums[i];
                int maxval=Math.max(v,nums[i]);
                map.put(digsum,maxval);
                ans=Math.max(ans,sum);
            }
            else map.put(digsum,nums[i]);
        }
        return ans;
    }
    private int digsum(int num){
        int ans=0;
        while(num>0){
            int r=num%10;
            ans+=r;
            num=num/10;
        }
        return ans;
    }
}
