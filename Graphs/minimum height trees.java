class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            //since unidirected graph u to v as well as v to u
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        while (n > 2) { //ans can at most be 2 nodes
            int size = q.size();
            n = n - size;
            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}
//dry run for better understanding
// TC and SC of O(n) approx
