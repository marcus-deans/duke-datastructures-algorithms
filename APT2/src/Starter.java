import java.util.Arrays;
import java.util.HashSet;

public class Starter {
    public int begins(String[] words, String first) {
        //remove duplicates from word given
        int counter = 0;
        words = new HashSet<String>(Arrays.asList(words)).toArray(new String[0]);
        for (int x =0; x< words.length; x++){
            if (((words[x]).charAt(0))==(first.charAt(0))){
                counter += 1;
            }
        }
        return counter;
    }
}
