class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        // mark all edges 0 and its connecting region as # using dfs
        for(int i=0;i<m;i++){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for(int j=0;j<n;j++){
            dfs(board,0,j);
            dfs(board,m-1,j);
        }
        //flip remaining 0 if any to X
        //flip back # to 0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(char[][] board,int i,int j){
        int m=board.length;
        int n=board[0].length;
        if(i>=0 && i<m && j>=0 && j<n && board[i][j]=='O'){
            board[i][j]='#';
            dfs(board,i+1,j);
            dfs(board,i,j+1);
            dfs(board,i,j-1);
            dfs(board,i-1,j);
        }
    }
}



//WITHOUT ALTERING ORIGINAL DATA I.E '#' INSTEAD USED A VISITED

class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        // mark all edges with 0 and its connecting region as visited using dfs
        for(int i=0;i<m;i++){
            if(!vis[i][0]  && board[i][0]=='O'){
                dfs(board,vis,i,0);
            } 
            if(!vis[i][n-1] && board[i][n-1]=='O'){
                dfs(board,vis,i,n-1);
            }  
        }
        for(int j=0;j<n;j++){
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(board,vis,0,j);
            } 
            if(!vis[m-1][j] && board[m-1][j]=='O'){
                dfs(board,vis,m-1,j);
            }  
        }
        //flip remaining unvisited 0 if any to X
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(char[][] board,boolean[][] vis,int i,int j){
        int m=board.length;
        int n=board[0].length;
        if(i>=0 && i<m && j>=0 && j<n && !vis[i][j] && board[i][j]=='O'){
            vis[i][j]=true;
            dfs(board,vis,i+1,j);
            dfs(board,vis,i,j+1);
            dfs(board,vis,i,j-1);
            dfs(board,vis,i-1,j);
        }
    }
}
