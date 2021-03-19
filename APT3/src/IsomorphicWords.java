import java.util.HashMap;

public class IsomorphicWords {
    public int countPairs(String[] words) {

        int total = 0;
        for(int j =0; j < words.length; j++){
            String jword = iso(words[j]);
            for(int k = j+1; k < words.length; k ++){
                String kword = iso(words[k]);
                if (jword.equals(kword)){
                    total += 1;
                }
            }
        }
        return total;
    }
    public String iso (String message){
                HashMap<Character, Character> conver = new HashMap<>();
                char[] origin = new char[message.length()];
                for (int x = 0; x < message.length(); x++) {
                    origin[x] = message.charAt(x);
                }
                int lett = 97;
                for (int x = 0; x < origin.length; x++) {
                    if (conver.containsKey(origin[x])) {
                        origin[x] = conver.get(origin[x]);
                    }
                    else {
                        conver.put(origin[x], (char) lett);
                        origin[x] = (char) lett;
                        lett += 1;
                    }
        }
        return new String(origin);
    }
}