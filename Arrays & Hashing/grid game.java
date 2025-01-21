class Solution {
    public long gridGame(int[][] grid) {
        long row1sum=0;
        for(int i:grid[0]){
            row1sum+=i;
        }
        long row2sum=0;
        long minres=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            row1sum-=grid[0][i];
            minres=Math.min(minres,Math.max(row1sum,row2sum));
            row2sum+=grid[1][i];
        }
        return minres;

    }
}
