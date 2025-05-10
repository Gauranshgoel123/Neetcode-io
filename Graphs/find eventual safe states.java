class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        List<Integer> ans=new ArrayList<>();
        int[] vis=new int[v];
        int[] pathvis=new int[v];
        for(int i=0;i<v;i++){
            if(dfs_checkcycle(i,graph,vis,pathvis)==false){
                ans.add(i);
            }   
        }
        return ans;
    }
    private boolean dfs_checkcycle(int node,int[][] graph,int[] vis,int[] pathvis){
        vis[node]=1;
        pathvis[node]=1;
        for(int i:graph[node]){
            if(vis[i]==0){
                if(dfs_checkcycle(i,graph,vis,pathvis)==true){
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
