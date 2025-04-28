class Pair{
    int row;
    int col;
    int step;
    public Pair(int row,int col,int step){
        this.row=row;
        this.col=col;
        this.step=step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int[] dc={0,1,0,-1};
        int[] dr={-1,0,1,0};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int s=q.peek().step;
            q.remove();
            ans[r][c]=s;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc,s+1));
                }
            }
        }
        return ans;
    }
}
