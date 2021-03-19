import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BigWord {
    public String most(String[] sentences){
        ArrayList<String> eleme = new ArrayList<String>(0);
        //String[] eleme = new String[sentences.length]
        for(int x = 0; x<sentences.length; x++){
            String[] conten = sentences[x].split(" ");
            for(int y =0; y < conten.length; y++){
                conten[y] = (conten[y].toLowerCase());
                eleme.add(conten[y]);
            }
        }
        HashSet<String> arcon = new HashSet<>(eleme);
        String[] indices = new String[arcon.size()];
        arcon.toArray(indices);
        int curcount = 0;
        int maxcount = 0;
        String maxstr = "";
        for (int z = 0; z<indices.length; z++){
            curcount = 0;
            for (int p = 0; p<eleme.size(); p++){
                if (indices[z].equals(eleme.get(p))) {
                    curcount += 1;
                }
            }
            if (curcount>maxcount){
                maxcount = curcount;
                maxstr = indices[z];
            }
        }

        return maxstr;
    }
}
