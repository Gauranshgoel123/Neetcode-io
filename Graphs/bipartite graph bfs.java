class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int[] color=new int[m];
        for(int i=0;i<m;i++){
            color[i]=-1;
        }
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(check(graph,color,i)==false) return false;
            }
        }
        return true;
    }
    private boolean check(int[][] graph,int[] color,int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int i:graph[node]){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.add(i);
                }
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
