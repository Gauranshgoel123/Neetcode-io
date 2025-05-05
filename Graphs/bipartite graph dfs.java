class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int[] color=new int[m];
        for(int i=0;i<m;i++){
            color[i]=-1;
        }
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(dfs(graph,color,i,0)==false) return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph,int[] color,int node,int col){
        color[node]=col;
        for(int i:graph[node]){
            if(color[i]==-1){
                if(dfs(graph,color,i,1-col)==false) return false;
            }
            else if(color[i]==col){
                return false;
            }
        }
        return true;
    }
}
