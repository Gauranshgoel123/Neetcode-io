class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int guess = matrix[row][col];

            if (guess == target) {
                return true;
            } else if (guess < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;        
    }
}





class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            int len=matrix[i].length;
            int start=matrix[i][0];
            int end=matrix[i][len-1];
            if(target>=start && target<=end){
                if(binary(0,len-1,target,matrix[i])) return true;
            }
        }
        return false;
    }
    private boolean binary(int start,int end,int target,int[] arr){
        while(start<=end){
            int mid = start + ((end - start) / 2);
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}
