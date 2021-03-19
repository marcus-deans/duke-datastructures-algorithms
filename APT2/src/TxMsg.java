import java.util.Arrays;
import java.util.HashSet;

/*public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        player = new HashSet<String>(Arrays.asList(player)).toArray(new String[0]);
        dictionary = new HashSet<String>(Arrays.asList(dictionary)).toArray(new String[0]);

        int counter = 0;
        for (int x = 0; x< player.length; x++){
            for (int y = 0; y < dictionary.length; y++){
                if (player[x].equals(dictionary[y])){
                    counter += (Math.pow((player[x].length()),2));
                }
            }
        }
        // you write code here
        return counter;
    }
}*/

public class TxMsg {
    public String getMessage(String original){
        String[] separate = original.split(" ");
        char[] vowlist = {'a','e','i','o','u'};
        for (int x = 0; x<separate.length; x++){
            boolean allvowel = false;
            int vowcount = 0;
            for (int p =0; p<vowlist.length; p++) {
                for (int y = 0; y < separate[x].length(); y++) { //check that there is at least one consonant by counting number of vowels
                    if (separate[x].charAt(y) == vowlist[p]) {
                        vowcount++;
                    }
                }
            }
            if (vowcount == separate[x].length()) { //break if comprised exclusively of vowels
                allvowel = true;
            }
            for (int q = 0; q<vowlist.length; q++){
                for (int z = 0; z<separate[x].length(); z++){
                    if((separate[x].charAt(z)!=vowlist[q]) &&(separate[x].charAt(z-1)!=vowlist[q])){ //if two consonants in a row
                        String sanscons = removeCharAt(separate[x],z);
                        separate[x] = sanscons;
                    }
                    if(separate[x].charAt(z)==vowlist[q]) { //removes all vowels from a word containing at least 1 consonant
                        String sansvowel = removeCharAt(separate[x],z);
                        separate[x] = sansvowel;
                    }
                }
            }
        }
        return String.join(" ",separate);
    }
    public String removeCharAt(String str, int p){
        return str.substring(0,p) + str.substring(p+1);
    }
    //public String consonantRemover(String str, int p){
    //}
}
