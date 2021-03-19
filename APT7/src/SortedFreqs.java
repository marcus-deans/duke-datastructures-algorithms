import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class SortedFreqs {
    public int[] freqs(String[] data){
        TreeSet<String> set = new TreeSet<>(Arrays.asList(data));
        int[] ret = new int[set.size()];
        int index = 0;
        for(String s : set){
            ret[index] = Collections.frequency(Arrays.asList(data), s);
            index++;
        }
        return ret;
        //extract value: TreeMap<String, Integer>
    }
}
