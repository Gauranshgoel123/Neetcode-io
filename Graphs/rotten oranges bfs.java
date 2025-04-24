class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int ans=0;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int time=q.peek().time;
            ans=Math.max(ans,time);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1){
                    vis[nr][nc]=2;
                    q.add(new Pair(nr,nc,time+1));
                    cnt++;
                }
            }
        }  
        if(cnt!=fresh) return -1;
        return ans;
    }
}
