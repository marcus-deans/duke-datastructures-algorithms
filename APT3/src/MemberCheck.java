import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {
        HashSet<String> alpha = new HashSet<String>(Arrays.asList(club1));
        HashSet<String> ab = new HashSet<String>(Arrays.asList(club1));
        HashSet<String> bravo = new HashSet<String>(Arrays.asList(club2));
        HashSet<String> bc = new HashSet<String>(Arrays.asList(club2));
        HashSet<String> charlie = new HashSet<String>(Arrays.asList(club3));
        HashSet<String> ca = new HashSet<String>(Arrays.asList(club3));
            ab.retainAll(bravo);
            bc.retainAll(charlie);
            ca.retainAll(alpha);
        //Collections.sort(eleme);
        HashSet<String> dupli = new HashSet<String>() {{
            addAll(ab);
            addAll(bc);
            addAll(ca);
        }};
        String[] fina = new String[dupli.size()];
        dupli.toArray(fina);
        Arrays.sort(fina);
        return fina;
    }
}
