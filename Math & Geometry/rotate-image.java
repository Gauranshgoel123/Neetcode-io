class Solution {
    public void rotate(int[][] matrix) {
        //transpose and then reverse each row of the matrix **IN PLACE
        //transpose in place swap upper traingular matrix part of the array
        for(int i=0;i<matrix.length-1;i++){
            for(int j=i+1;j<matrix.length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        System.out.println(matrix);
        //reverse each row
        for(int[] row:matrix){
            swap(row);
        }
    }
    private void swap(int[] nums){
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}
