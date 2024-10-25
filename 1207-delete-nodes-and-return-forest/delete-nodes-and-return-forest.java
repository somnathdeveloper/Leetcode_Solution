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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> list = new ArrayList<>();
        for(int i=0;i<to_delete.length;i++){
            if(root.val==to_delete[i]){
                break;
            }
            if(i==to_delete.length-1){
                list.add(root);
            }
        }
        help(root,list,to_delete);
        return list;
    }
    public TreeNode help(TreeNode root,ArrayList<TreeNode> list,int[] to_delete){
        if(root==null){
            return null;
        }
        TreeNode left = help(root.left,list,to_delete);
        TreeNode right = help(root.right,list,to_delete);
        if(left==null){
            root.left=null;
        }
        if(right==null){
            root.right=null;
        }
        for(int i=0;i<to_delete.length;i++){
            if(root.val==to_delete[i]){
                if(root.left!=null){
                    list.add(root.left);
                }
                if(root.right!=null){
                    list.add(root.right);
                }
                return null;
            }
        }
        return root;
    }
}