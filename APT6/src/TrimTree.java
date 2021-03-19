public class TrimTree {
    public TreeNode trim(TreeNode t, int low, int high){

        if(t==null){
            return null;
        }
        t.left = trim(t.left, low, high);
        t.right = trim(t.right, low, high);

        if(t.info < low){
            TreeNode rchild = t.right;
            t = null;
            return rchild;
        }
        if(t.info > high){
            TreeNode lchild = t.left;
            t = null;
            return lchild;
        }
//        if(t.info > high || t.info < low){
////            return trim(t.left, low, high);
//            if(t.right.info <= high && t.right.info >= low){
//                return trim(t.right, low, high);
//            }
//            else if(t.left.info <= high && t.right.info >= low){
//                return trim(t.left, low, high);
//            }
////            if((t.left.info > high || t.left.info < low)&&(t.right.info > high || t.right.info < low)){
////                return null;
////            }
//            else{
//                return null;
//            }
//        }
//        if(t.info <= high && t.info >= low){
//            t.left = trim(t.left, low, high);
//            t.right = trim(t.right, low, high);
//        }
        return t;

//        if(tree.left == null && tree.right == null){
//            return tree;
//        }
//        if(tree.left == null && tree.right != null){
//            return tighten(tree.right);
//        }
//        if(tree.right == null && tree.left != null){
//            return tighten(tree.left);
//        }
//        if(tree.left != null && tree.right != null){
//            tree.left = tighten(tree.left);
//            tree.right = tighten(tree.right);
//        }
////        tree.left = tighten(tree.left);
////        tree.right = tighten(tree.right);
//        return tree;
    }
}
