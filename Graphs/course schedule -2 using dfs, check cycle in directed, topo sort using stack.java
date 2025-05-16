class Solution {
    public int[] findOrder(int v, int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }       
        for(int[] edge:graph){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] vis=new int[v];
        int[] pathvis = new int[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathvis,adj,st)){
                    return new int[]{};
                }
            }
        }
        int[] ans=new int[v];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return i==v ? ans : new int[]{};
   }
   private boolean dfs(int node,int[] vis,int[] pathvis,List<List<Integer>> adj,Stack<Integer> st){
        vis[node]=1;
        pathvis[node]=1;
        for(int neigh:adj.get(node)){
            if(vis[neigh]==0){
                if(dfs(neigh,vis,pathvis,adj,st)){
                    return true;
                }
            }
            else if(pathvis[neigh]==1){
                return true;
            }   
        }
        st.push(node);
        pathvis[node]=0;
        return false;
    }
}
