public class TreeSumChild {
    int total = 0;
    public int calculate(TreeNode root, String type){
        if(root == null){
            return 0;
        }

        total += calculate(root.left, type);
        total += calculate(root.right, type);

        if((type.equals("R"))&&((root.left == null)&&(root.right != null))){
//            total += root.info;
            return root.info;
        }
        if((type.equals("L"))&&((root.right == null)&&(root.left != null))){
//            total += root.info;
            return root.info;
        }
//        findNodes(root, type);
        return 0;
//        return calculate(root.left, type)+calculate(root.right, type);
    }
    public void findNodes(TreeNode root, String type){

        findNodes(root.left, type);
        findNodes(root.right, type);
    }
}
