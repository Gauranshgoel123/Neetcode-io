/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    private Set<Integer> set=new HashSet<>(); //for constant lookup in find() operation

    public FindElements(TreeNode root) {
        dfs(root,0); //dfs traversal to find recovered tree
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void dfs(TreeNode root,int value){
        if(root==null) return;
        set.add(value);
        int leftval=2*value+1;
        dfs(root.left,leftval);
        int rightval=2*value+2;
        dfs(root.right,rightval);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
