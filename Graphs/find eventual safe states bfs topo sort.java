class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjrev=new ArrayList<>();
        int v=graph.length;
        for(int i=0;i<v;i++){
            adjrev.add(new ArrayList<>());
        }
        int[] indeg=new int[v];
        for(int i=0;i<v;i++){
            for(int neigh:graph[i]){
                adjrev.get(neigh).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int i:adjrev.get(node)){
                indeg[i]--;
                if(indeg[i]==0){
                    q.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
