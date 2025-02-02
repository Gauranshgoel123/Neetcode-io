class Solution {
    public boolean check(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[(i+1)%n] < nums[i]){
                count++;
            }
            if(count>1) return false;
        }
        return true;
    }
}

// 3,4,5,1,2
// 3,4 -> ok
// 4,5 -> ok
// 5,1 -> count++
// 1,2 -> ok
// 2,3 -> ok

// if anywhere count>1 return false


// 2,1,3,4
// 2,1 -> count++
// 1,3 -> ok
// 3,4 -> ok
// 4,2 -> count++

// since count=2 i.e. >1 hence return false
