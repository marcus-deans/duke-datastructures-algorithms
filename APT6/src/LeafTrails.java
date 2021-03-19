import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Set;

public class LeafTrails {
    TreeMap<Integer, String> myList;
    public String[] trails(TreeNode tree){
        myList = new TreeMap<>();
        if (tree == null){
            return null;
        }
        findPaths(tree, "");
//        Collections.sort(myList);
        Set<Integer> keys = myList.keySet();
        String[] fina = new String[myList.size()];
        int count = 0;
        for(int x: keys){
            fina[count] = myList.get(x);
            count ++;
        }
        return fina;
    }
    public void findPaths(TreeNode t, String path){
        if(t == null){
            return;
        }
        if(t.left == null && t.right == null){
            myList.put(t.info, path);
            return;
        }
        else {
//            path += t.info;
            findPaths(t.left, path + "0");
            findPaths(t.right, path + "1");
        }
    }
}
