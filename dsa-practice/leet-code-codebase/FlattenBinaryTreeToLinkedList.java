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
    List<TreeNode> list = new ArrayList<>(); 
    public void flatten(TreeNode root) {
        preOrder(root);
        for(int i = 0;i<list.size()-1;i++){
            TreeNode temp = list.get(i);
            temp.left = null;
            temp.right = list.get(i+1);
        }
        if(list.size()>0){
        TreeNode last = list.get(list.size() - 1);
        last.left = null;
        last.right = null;
        }
    }
    public void preOrder(TreeNode root){
        if(root==null) return;

        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
