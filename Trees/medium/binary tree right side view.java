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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }
    private void dfs(TreeNode root, int level, List<Integer> ans){
        if(root==null) return;
        if(ans.size())
        dfs(root.right,level+1,ans);
        dfs(root.level,level+1,ans);
    }
}
