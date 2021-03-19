import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LargestCost {
    public String[] cost (String[] words){
        // change this code
        HashMap<Character, Integer>  valu = new HashMap<>();
        valu.put('a', 1);
        valu.put('f', 1);
        valu.put('k', 1);
        valu.put('p', 1);
        valu.put('u', 1);
        valu.put('z', 1);

        valu.put('b', 2);
        valu.put('g', 2);
        valu.put('l', 2);
        valu.put('q', 2);
        valu.put('v', 2);

        valu.put('c', 3);
        valu.put('h', 3);
        valu.put('m', 3);
        valu.put('r', 3);
        valu.put('w', 3);

        valu.put('d', 4);
        valu.put('i', 4);
        valu.put('n', 4);
        valu.put('s', 4);
        valu.put('x', 4);

        valu.put('e', 5);
        valu.put('j', 5);
        valu.put('o', 5);
        valu.put('t', 5);
        valu.put('y', 5);

        Integer[] wordsn = new Integer[words.length];
        for(int x= 0; x<words.length; x++) {
            int curword = 0;
            for (int y = 0; y < words[x].length(); y++) {
                curword += valu.get(words[x].charAt(y));
            }
            wordsn[x] = curword;
        }
        int max = Collections.max(Arrays.asList(wordsn));
        ArrayList<String> biggest = new ArrayList<String>(0);
        for (int x = 0; x<words.length; x++){
            if (wordsn[x] == max){
                biggest.add(words[x]);
            }
        }
        Collections.sort(biggest);
        String[] fina = new String[biggest.size()];
        for(int z = 0; z<biggest.size(); z++){
            fina[z] = biggest.get(z);
        }
        return fina;
    }
}
