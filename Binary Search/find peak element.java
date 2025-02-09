class Solution {
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-1;
        if(nums.length==1){
            return 0;
        }
        while(l<=r){
            int m =l+(r-l)/2;
            if(m==0){
                if(nums[0]>nums[1]) return 0;
                else return 1;
            }
            else if(m==nums.length-1){
                if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
                else return nums.length-2;
            }
            else if(nums[m]>nums[m+1] && nums[m]>nums[m-1]){
                return m;
            }
            //left half
            else if(nums[m]>nums[m-1]){
                l=m+1;
            }        
            //right half
            else{
                r=m-1;
            }
        }
        return -1;
    }
}



class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n-1] > nums[n-2]) {
            return n-1;
        }
        int low = 1 , high = n - 2;
        while(low <= high) {
            int mid = (low + (high - low) / 2);
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if (nums[mid] > nums[mid-1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
