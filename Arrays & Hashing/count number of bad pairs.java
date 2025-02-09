class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        long totalpairs=0;
        for(int i=0;i<nums.length;i++){
            totalpairs+=i;
        }
        long goodpairs=0;
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-i;
            goodpairs+=map.getOrDefault(diff,0);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }   
        return totalpairs-goodpairs;
    }
}
