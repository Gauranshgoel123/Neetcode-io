class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int cnt=0;
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int i,boolean[] vis,int[][] isconnected){
        vis[i]=true;
        for(int j=0;j<isconnected.length;j++){
            if(isconnected[i][j]==1 && !vis[j]){
                dfs(j,vis,isconnected);
            }
        }
    }
}
