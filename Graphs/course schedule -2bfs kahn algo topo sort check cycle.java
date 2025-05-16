easy check cycle in directed algo..solved using BFS topo sot kahn algo

  class Solution {
    public int[] findOrder(int v, int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }       
        for(int[] edge:graph){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] indeg=new int[v];
        int[] ans=new int[v];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            for(int j:adj.get(i)){
                indeg[j]++;
            }
        }
        for(int i=0;i<v;i++){
            if(indeg[i]==0) q.add(i);
        }
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[i]=node;
            i++;
            for(int j:adj.get(node)){
                indeg[j]--;
                if(indeg[j]==0){
                    q.add(j);
                }
            }
        }
        return (i==v)?ans:new int[]{};
    }
}
