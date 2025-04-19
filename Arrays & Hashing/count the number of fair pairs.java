class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long upperbound=find(nums,upper+1); // sum<upper+1 or sum<=upper
        long lowerbound=find(nums,lower);   // sum<lower or sum<=lower-1
        return upperbound-lowerbound;       // (sum<=upper)-(sum<lower)= FINAL ANS
    }
    private long find(int[] nums,int val){
        long res=0;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            if(nums[l]+nums[r]<val){
                res+=r-l; //width=number of possible pairs
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}

//TC: O(NLOGN)
//SC: O(1)
