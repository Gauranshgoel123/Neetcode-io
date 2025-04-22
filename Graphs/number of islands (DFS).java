class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
    private void dfs(int r,int c,int[][] vis, char[][] grid){
       if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1' && vis[r][c]==0){
            vis[r][c]=1;
            dfs(r-1,c,vis,grid);
            dfs(r+1,c,vis,grid);
            dfs(r,c-1,vis,grid);
            dfs(r,c+1,vis,grid);
       }
    }
}
