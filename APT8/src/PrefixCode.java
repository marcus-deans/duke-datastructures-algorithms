import java.util.ArrayList;
import java.util.Collections;

public class PrefixCode {
    public String isOne(String[] words) {
        String returns = "Yes";
        ArrayList<Integer> matches = new ArrayList<Integer>();

        for (int base = 0; base < words.length; base++)
            for (int compare = base + 1; compare < words.length; compare++) {
                if (base == compare) ;
                else {
                    if (words[base].length() > words[compare].length()) {
                        if ((words[base].substring(0, words[compare].length())).equals(words[compare])) {
                            matches.add(compare);
                        }
                    } else {
                        if ((words[compare].substring(0, words[base].length())).equals(words[base])) {
                            matches.add(base);
                        }
                    }
                }
            }
        if (matches.size() == 0) return returns;
        else return "No, " + Collections.min(matches);

    }
}
