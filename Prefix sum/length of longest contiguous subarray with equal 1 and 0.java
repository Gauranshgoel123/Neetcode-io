class Solution {
    public int findMaxLength(int[] nums) {
       /*
       treat
       0 as -1
       1 as +1
        maintain sum for r=each along with hashmap with (sum,index);
        */ 

        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) sum-=1;
            else if(nums[i]==1) sum+=1;
            if(map.containsKey(sum)){
                int idx=map.get(sum);
                int res=i-idx;
                if(res>ans){
                    ans=res;
                }
            }
            else{
                map.put(sum,i);
            }
        }
        return ans;
    }
}
