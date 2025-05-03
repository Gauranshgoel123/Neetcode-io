class Solution {
    public int maxAreaOfIsland(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        int maxarea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]==1){
                    int area=dfs(board,vis,i,j);
                    maxarea=Math.max(area,maxarea);
                }
            }
        }
        return maxarea;
    }
    private int dfs(int[][] board,boolean[][] vis,int r,int c){
        int area=1;
        vis[r][c]=true;
        int m=board.length;
        int n=board[0].length;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && board[nr][nc]==1){
                area+=dfs(board,vis,nr,nc);
            }
        }
        return area;
    }
}

//tc O(N*M)
//sc O(N*M)
