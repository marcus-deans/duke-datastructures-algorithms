import java.util.ArrayList;
import java.util.Collections;

public class AllPaths{
    ArrayList<String> myList;
    public String[] paths(TreeNode root){
        myList = new ArrayList<>();
        if (root == null){
            return new String[0];
        }
        findPaths(root,"");
        Collections.sort(myList);
        return myList.toArray(new String[0]);
    }
    public void findPaths(TreeNode t, String path){
        if(t == null){
            return;
        }

        if(t.left == null && t.right == null){
            myList.add(path + t.info);
            return;
        }
        else {
            path = path + t.info + "->";
            findPaths(t.left, path);
            findPaths(t.right, path);
        }
    }
}