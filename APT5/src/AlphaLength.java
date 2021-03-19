import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class AlphaLength {
    HashSet<String> indi = new HashSet<>();
    public ListNode create (String[] words){
        for(String x: words){
            indi.add(x);
        }
        ArrayList<String> sortif = new ArrayList<>(indi);
        int[] meh = new int[sortif.size()];
        Collections.sort(sortif);
        for(int x = 0; x<sortif.size(); x++){
            meh[x] = sortif.get(x).length();
        }
        ListNode fina = new ListNode(meh[0]);
        ListNode charlie = fina;
        for(int p = 1; p< meh.length; p++){
            charlie.next = new ListNode(meh[p]);
            charlie = charlie.next;
        }
        return fina;
    }
}
