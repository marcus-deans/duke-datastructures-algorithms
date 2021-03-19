public class removeNodes {
    public static TreeNode removeNodes(TreeNode root, int number){
        if (root == null){
            return root;
        }
        //Part 1 - Two recursive calls missing for subtrees
        root.left = removeNodes(root.left, number);
        root.right = removeNodes(root.right, number);

        if (root.info % number != 0){
            return root;
        }
        // node must be removed - there are three cases
        //part 2- case if node in a leaf node
        else if((root.left == null)&&(root.right == null)){
            return null;
        }
        //part 3 - case if node has only one child
        else if((root.left == null)&&(root.right!=null)){
//            return removeNodes(root.right, number);
            return root.right;
        }
        else if((root.left!=null)&&(root.right==null)){
//            return removeNodes(root.left, number);
            return root.left;
        }
        //part 4 - case if node has two children
        else if((root.left!=null)&&(root.right!=null)){
            leftMost(root.right).left = root.left;
            return root.right;
//            return removeNodes(root.right, number);
        }
        return root;
    }

    public static TreeNode leftMost(TreeNode root){
        if(root.left == null){
            return root;
        }
        else{
            return leftMost(root.left);
        }
    }
    public static void main(String[] args){
        TreeNode tr = new TreeNode(24);
        TreeNode result = tr;
        tr.left = new TreeNode(15);
        tr.left.left = new TreeNode(18);
        tr.left.left.right = new TreeNode(7);
        tr.left.right = new TreeNode(27);
        tr.left.right.left = new TreeNode(36);
        tr.left.right.left.left = new TreeNode(54);
        tr.left.right.left.right = new TreeNode(12);
        tr.right = new TreeNode(9);
        tr.right.left = new TreeNode(32);
        tr.right.right = new TreeNode(45);
        tr.right.left.left = new TreeNode(20);
        tr.right.right.left = new TreeNode(21);
        (removeNodes(tr,5));
        printLeaves(result);
        System.out.println(2%2);
    }

    public static void printLeaves(TreeNode node){
        if (node == null){
            return;
        }

        if((node.left==null)&&(node.right))
    }
}
