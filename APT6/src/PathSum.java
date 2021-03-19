import java.util.ArrayList;
import java.util.Collections;

public class PathSum {
    ArrayList<Integer> myList;
    public int hasPath(int target, TreeNode root){
        myList = new ArrayList<>();
        if (root == null){
            return 0;
        }
        findPaths(root, 0);
        Collections.sort(myList);
        for(int x = 0; x<myList.size(); x++){
            if(myList.get(x)==target){
                return 1;
            }
        }
        return 0;
    }
    public void findPaths(TreeNode t, int path){
        if(t == null){
            return;
        }
        if(t.left == null && t.right == null){
            myList.add(path += t.info);
            return;
        }
        else {
            path += t.info;
            findPaths(t.left, path);
            findPaths(t.right, path);
        }
    }
}
