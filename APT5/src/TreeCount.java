public class TreeCount {
    int numero = 0;
    public int count(TreeNode treef){
        if(treef == null) return 0;
        tamp(treef);
        return numero;
    }
    public void tamp(TreeNode tree){
        if(tree==null) {
            return;
        }
        tamp(tree.left);
        numero++;
        tamp(tree.right);
    }
}
