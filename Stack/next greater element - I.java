class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                ngeMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            ngeMap.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngeMap.get(nums1[i]);
        }
        return result;
    }
}

// TC: O(N+M)
// SC:O(N+M)


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int[] ans=new int[nums1.length];
        int i=0;
        for(int num:nums1){
            int index=map.get(num);
            int val=findnext(nums2,index);
            ans[i]=val;
            i++;
        }
        return ans;    
    }
    private int findnext(int[] nums,int idx){
        int ans=-1;
        for(int i=idx+1;i<nums.length;i++){
            if(nums[i]>nums[idx]){
                ans=nums[i];
                break;
            }
        }
        return ans;
    }
}

//TC: O(N*M)
//SC: O(N+M)
