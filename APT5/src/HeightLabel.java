public class HeightLabel {
    public TreeNode rewire(TreeNode t){
        //replace with working code
        if (t == null) return null;
        return new TreeNode(height(t), rewire(t.left), rewire(t.right));
    }
    private int height(TreeNode t){
        if(t==null) return 0;
        return 1 + Math.max(height(t.left), height(t.right));
    }
}
