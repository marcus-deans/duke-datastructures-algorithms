import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UniqueTreeValues {
    HashSet<Integer> indi = new HashSet<>();
    public int[] unique(TreeNode root){
        if(root == null) return new int[0];
        tamp(root);
        ArrayList<Integer> sortif = new ArrayList<>(indi);
        Collections.sort(sortif);
        int[] fina = new int[sortif.size()];
        for(int x = 0; x<sortif.size(); x++){
            fina[x] = sortif.get(x);
        }
        return fina;
    }
    public void tamp(TreeNode tree){
        if(tree==null) {
            return;
        }
        else{
            indi.add(tree.info);
        }
        tamp(tree.left);
        tamp(tree.right);
    }
}
