class Solution {
    public int subarraySum(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int prefsum=0;
        int ans=0;
        map.put(0,1);
        for(int i:arr){
            prefsum+=i;
            if(map.containsKey(prefsum-k)){
                ans+=map.get(prefsum-k);
            }
            map.put(prefsum,map.getOrDefault(prefsum,0)+1);
        }
        return ans;
    }
}
