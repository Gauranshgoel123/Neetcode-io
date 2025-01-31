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
    public boolean isSymmetric(TreeNode root) {
        return recur(root.left,root.right);
    }
    private boolean recur(TreeNode leftroot,TreeNode rightroot){
        if(leftroot==null && rightroot==null) return true;
        if(leftroot==null || rightroot==null) return false;
        if(leftroot.val!=rightroot.val) return false;
        boolean way1=recur(leftroot.left,rightroot.right);
        boolean way2=recur(leftroot.right,rightroot.left);
        return way1&&way2;
    }
}
