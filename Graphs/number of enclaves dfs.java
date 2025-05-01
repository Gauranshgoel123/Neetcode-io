class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(!vis[i][0] && grid[i][0]==1){
                dfs(grid,vis,i,0);
            }
            if(!vis[i][n-1] && grid[i][n-1]==1){
                dfs(grid,vis,i,n-1);
            }
        }
        for(int j=0;j<n;j++){
            if(!vis[0][j] && grid[0][j]==1){
                dfs(grid,vis,0,j);
            }
            if(!vis[m-1][j] && grid[m-1][j]==1){
                dfs(grid,vis,m-1,j);
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void dfs(int[][] grid,boolean[][] vis,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i>=0 && i<m && j>=0 && j<n && !vis[i][j] && grid[i][j]==1){
            vis[i][j]=true;
            dfs(grid,vis,i+1,j);
            dfs(grid,vis,i-1,j);
            dfs(grid,vis,i,j+1);
            dfs(grid,vis,i,j-1);
        }
    }
}
