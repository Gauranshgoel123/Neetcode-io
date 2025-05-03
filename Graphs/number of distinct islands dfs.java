to check if islands are equal, we can store the shape in a set and just return the set size

but how to store the shape of island?

see video explanation for this 

important: we cannot use custom pair class with a set for its uniqueness feature since : 
You're using HashSet<List<Pair>> to store distinct island shapes, but Pair does not override equals() and hashCode() methods.

Java uses equals() and hashCode() to compare objects in HashSet, and since you're storing lists of Pair objects, two identical-looking islands will be considered different unless Pair defines how equality and hashing should work.

so we can instead use string to store in list, row and col seperated by a space,

Source Code:
class Solution {
    public int countDistinctIslands(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        HashSet<List<String>> set=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    List<String> list=new ArrayList<>();
                    dfs(grid,vis,i,j,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid,boolean[][] vis,int row, int col,List<String> list,int row0,int col0){
        vis[row][col]=true;
        list.add(toString(row-row0,col-col0));
        int m=grid.length;
        int n=grid[0].length;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(grid,vis,nr,nc,list,row0,col0);
            }
        }
    }
    private String toString(int r,int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}


