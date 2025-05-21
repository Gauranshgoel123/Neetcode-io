class Pair{
    int a;
    int b;
    public Pair(int x,int y){
        this.a=x;
        this.b=y;
    }
}
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        int[] dist=new int[adj.size()];
        for(int i=0;i<dist.length;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.a;
            int wt=p.b;
            for(int i:adj.get(node)){
                if((wt+1)<dist[i]){
                    dist[i]=wt+1;
                    q.add(new Pair(i,wt+1));
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }
}
