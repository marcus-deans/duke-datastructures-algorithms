import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
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
}
