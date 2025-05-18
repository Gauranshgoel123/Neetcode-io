//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public String findOrder(String[] words) {
        
        List<List<Integer>> adj=new ArrayList<>();
        boolean[] exist=new boolean[26];
        int[] indeg=new int[26];
    
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        
        for(String word:words){
            for(char c:word.toCharArray()){
                exist[c-'a']=true;
            }
        }
        
        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int len=Math.min(s1.length(),s2.length());
            int j=0;
            while(j<len && s1.charAt(j)==s2.charAt(j)){
                j++;
            }
            if(j<len){
                adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');   
                indeg[s2.charAt(j) - 'a']++;
            }
            else if(s1.length() > s2.length()){
                //if first strring longer than second then not possible
                return "";
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(exist[i] && indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int i:adj.get(node)){
                indeg[i]--;
                if(indeg[i]==0){
                    q.add(i);
                }
            }
        }
        
        for(int i=0;i<26;i++){
            if(exist[i] && indeg[i]!=0){
                return "";
            }
        }
        
        
        
        String res="";
        for(int i:ans){
            res=res+(char)(i+(int)('a'));
        }
        return res;
        
    }
}


//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends










import java.util.*;


class Solution {
    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        for (int it : topo) {
            ans = ans + (char)(it + (int)('a'));
        }

        return ans;

    }
}

public class tUf {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        Solution obj = new Solution();
        String ans = obj.findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
