class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
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
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
    private void bfs(int r,int c,int[][] vis, char[][] grid){
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        vis[r][c]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(r,c));
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            //look fir neighbours in 4 directions
            for(int[] d:directions){
                int nrow=row+d[0];
                int ncol=col+d[1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol));
                }
                
            }
        }
    }
}
