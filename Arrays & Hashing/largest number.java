class Solution {
    public String largestNumber(int[] nums) {
        String[] arr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));

        if(arr[0].equals("0")) return "0";
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            ans.append(String.valueOf(arr[i]));
        }
        return ans.toString();
    }
}

/**
Convert Integers to Strings: Since comparing individual digits of integers won't work directly for concatenation, first convert the integer array into an array of strings. This allows us to concatenate and compare the results of a + b and b + a.

Custom Sorting: Use a custom comparator to sort the string array. The comparator should compare two strings a and b by checking the results of a + b vs b + a. If a + b is larger, then a should come before b in the sorted array.

Edge Case: After sorting, if the largest number is "0" (i.e., if the first element in the sorted array is "0"), return "0", since this means all numbers were zeros.

Construct the Result: Use a StringBuilder to concatenate all the strings in the sorted array into the final result. */
