public class TreeTighten {
    public TreeNode tighten(TreeNode tree){
        if(tree == null){
            return null;
        }
        if(tree.left == null && tree.right == null){
            return tree;
        }
        if(tree.left == null && tree.right != null){
            return tighten(tree.right);
        }
        if(tree.right == null && tree.left != null){
            return tighten(tree.left);
        }
        if(tree.left != null && tree.right != null){
            tree.left = tighten(tree.left);
            tree.right = tighten(tree.right);
        }
//        tree.left = tighten(tree.left);
//        tree.right = tighten(tree.right);
        return tree;
    }
}
