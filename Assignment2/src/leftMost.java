public class leftMost {
    public TreeNode leftMost(TreeNode root){
        if(root.left == null){
            return root;
        }
        else{
            return leftMost(root.left);
        }
    }
}
