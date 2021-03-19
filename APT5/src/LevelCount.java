public class LevelCount {
    public int count(TreeNode t, int level){
        //working code
        if(t==null){
            return 0;
        }
        else if (level == 0){
            return 1;
        }
        return newwiring(t, level);
    }

    public int newwiring(TreeNode tester, int p){
        if (tester == null){
            return 0;
        }
        else{
            TreeNode alpha = tester.left;
            TreeNode bravo = tester.right;
            int numero = 0;

            if(p == 0){
                numero = 1;
            }
            else{
                numero += newwiring(alpha, p-1);
                numero += newwiring(bravo, p-1);
            }
            return numero;
        }
    }
}
