class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ans=grid;
        int el=grid[sr][sc];
        dfs(grid,sr,sc,color,ans,el);
        return ans;
    }
    private void dfs(int[][] grid,int sr,int sc,int color,int[][] ans,int el){
        int m=grid.length;
        int n=grid[0].length;
        if(sr>=0 && sr<m && sc>=0 && sc<n && grid[sr][sc]!=color && grid[sr][sc]==el){
            ans[sr][sc]=color;
            dfs(grid,sr,sc+1,color,ans,el);
            dfs(grid,sr,sc-1,color,ans,el);
            dfs(grid,sr+1,sc,color,ans,el);
            dfs(grid,sr-1,sc,color,ans,el);
        }
    }
}



//with using uncecessary visited 2d matrix
  class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ans=grid;
        int[][] vis=new int[m][n];
        int el=grid[sr][sc];
        dfs(grid,sr,sc,color,vis,ans,el);
        return ans;
    }
    private void dfs(int[][] grid,int sr,int sc,int color,int[][] vis,int[][] ans,int el){
        int m=grid.length;
        int n=grid[0].length;
        if(sr>=0 && sr<m && sc>=0 && sc<n && vis[sr][sc]==0 && grid[sr][sc]==el){
            vis[sr][sc]=1;
            ans[sr][sc]=color;
            dfs(grid,sr,sc+1,color,vis,ans,el);
            dfs(grid,sr,sc-1,color,vis,ans,el);
            dfs(grid,sr+1,sc,color,vis,ans,el);
            dfs(grid,sr-1,sc,color,vis,ans,el);
        }
    }
}
