class Solution {
    public boolean canFinish(int v, int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : graph) {
            adj.get(edge[1]).add(edge[0]); // from -> to
        }
        int[] vis=new int[v];
        int[] pathvis=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(dfs_checkcycle(i,adj,vis,pathvis)){
                    return false;
                }   
            }
        }
        return true;
    }
    private boolean dfs_checkcycle(int node,List<List<Integer>> adj,int[] vis,int[] pathvis){
        vis[node]=1;
        pathvis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(dfs_checkcycle(i,adj,vis,pathvis)==true){
                    return true;
                }
            }
            else if(pathvis[i]==1){
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
}
