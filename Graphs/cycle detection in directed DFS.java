//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathvis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int[] vis,int[] pathvis,List<List<Integer>> adj){
        vis[i]=1;
        pathvis[i]=1;
        for(int neigh:adj.get(i)){
            if(vis[neigh]==0){
                if(dfs(neigh,vis,pathvis,adj)) return true;
            }
            else if(pathvis[neigh]==1) return true;

        }
        pathvis[i]=0;
        return false;
    }
}
