//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int f,int s){
        this.first=f;
        this.second=s;
    }
}
// User function Template for Java
class Solution {
    
    private void topodfs(int node,ArrayList<ArrayList<Pair>> adj,int[] vis,Stack<Integer> stack){
        vis[node]=1;
        for(Pair i:adj.get(node)){
            int v=i.first;
            if(vis[v]==0){
                topodfs(v,adj,vis,stack);
            }
        }
        stack.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis=new int[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                topodfs(i,adj,vis,stack);
            }
        }
        int[] dist=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            for(Pair i:adj.get(node)){
                int v=i.first;
                int wt=i.second;
                if (dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[v]){
                    dist[v]=dist[node]+wt;
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
