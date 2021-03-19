import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortedLeaves {
    ArrayList<Character> myList;
    public String[] values(TreeNode root) {
        myList = new ArrayList<>();
        if (root == null) {
            return new String[0];
        }
        findPaths(root, "");
        Collections.sort(myList);
        String[] fina = new String[myList.size()];
        for(int x = 0; x<myList.size(); x++){
            fina[x] = myList.get(x).toString();
        }
//        return myList.toArray(new String[0]);
        return fina;
    }
    public void findPaths(TreeNode t, String path){
            if(t == null){
                return;
            }

            if(t.left == null && t.right == null){
                myList.add((char) t.info);
                return;
            }
            else {
//                path = path + t.info + "->";
                findPaths(t.left, path);
                findPaths(t.right, path);
            }
    }
}
