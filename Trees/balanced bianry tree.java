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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int hl=height(root.left);
        int hr=height(root.right);
        int diff=Math.abs(hr-hl);
        if(diff<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;     
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int l=height(root.left);
        int r=height(root.right);
        return 1+Math.max(l,r);
    }
}
