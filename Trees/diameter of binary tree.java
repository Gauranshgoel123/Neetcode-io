DEPTH FIRST SEARCH APPROACH

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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int[] res=new int[1];
        dfs(root,res);
        return res[0];
    }
    private int dfs(TreeNode root,int[] res){
        if(root==null) return 0;
        int l=dfs(root.left,res);
        int r=dfs(root.right,res);
        res[0]=Math.max(res[0],l+r);
        return 1+Math.max(l,r);
    }
}


//diameter = max depth of left + max depth of right
//2+1





BRUTE FORCE






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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=maxdepth(root.left)+maxdepth(root.right);
        int temp=Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(ans,temp);
    }
    private int maxdepth(TreeNode root){
        if(root==null) return 0;
        int l=maxdepth(root.left);
        int r=maxdepth(root.right);
        return 1+Math.max(l,r);
    }
}


//max depth of left + max depth of right
//2+1


