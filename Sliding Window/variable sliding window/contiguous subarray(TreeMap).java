class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int left=0;
        long count=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.lastKey()-map.firstKey() > 2){
                //decrement count of nums[left]
                map.put(nums[left],map.get(nums[left])-1);
                //remove nums[left] from map if its count becomes 0 after decrementing
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}
