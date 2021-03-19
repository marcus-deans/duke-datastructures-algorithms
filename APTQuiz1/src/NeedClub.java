import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NeedClub {
    public int howmany(String[] names, String[] clubs, String[] sports){
        HashSet uniqnames = new HashSet<>(Arrays.asList(names));
        HashSet uniqclubs = new HashSet<>(Arrays.asList(clubs));
        HashSet uniqsports = new HashSet<>(Arrays.asList(sports));
        uniqclubs.addAll(uniqsports);
        String[] involved = new String[uniqclubs.size()];
        uniqclubs.toArray(involved);
        String[] peeps = new String[uniqnames.size()];
        uniqnames.toArray(peeps);
        ArrayList<String> lose = new ArrayList<>(0);
        for (int x = 0; x<peeps.length; x++){
            boolean found = false;
            for (int y = 0; y<involved.length; y++){
                if (peeps[x].equals(involved[y])){
                    found = true;
                }
            }
            if(!found){
                lose.add(peeps[x]);
            }
        }
        return lose.size();
    }
}
