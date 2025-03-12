o(logn) using binary search with slightly modification

class Solution {
    public int maximumCount(int[] nums) {
        int negCount = binarySearch(nums, 0);
        int posCount = nums.length - binarySearch(nums, 1);
        return Math.max(negCount, posCount);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result=mid;
                right = mid - 1;
            }
        }
        return result;
    }
}


brute force

class Solution {
    public int maximumCount(int[] nums) {
        int cntn=0;
        int cntp=0;
        for(int i:nums){
            if(i<0) cntn++;
            else if(i>0) cntp++;
        }
        return Math.max(cntn,cntp);
    }
}
