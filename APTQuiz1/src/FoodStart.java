import java.util.ArrayList;
import java.util.HashSet;

public class FoodStart {
    public int count(String[] meals){
        // meh
        int fina = 0;
        ArrayList<Character> onehead = new ArrayList<>(0);
        for (int x = 0; x<meals.length; x++){
            String[] onesplit = meals[x].split(":");
            for (int y = 0; y<onesplit.length; y++){
                onehead.add(onesplit[y].charAt(0));
            }
        }
        HashSet<Character> uniq = new HashSet<Character>(onehead);
        return uniq.size();
    }
}
