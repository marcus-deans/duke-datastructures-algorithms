import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class SetAside {
    public String common(String[] list){
        String[] cur = list[0].split(" ");
        ArrayList<String> eleme = new ArrayList<String>(0);
        cur = new LinkedHashSet<String>(Arrays.asList(cur)).toArray(new String[0]);
        boolean found = false;
        for (int x=0; x<cur.length; x++){
            found = false;
            for (int y = 1; y<list.length; y++){
                found = false;
                String[] pac = list[y].split( " ");
                for (int z = 0; z<(pac.length); z++){
                    if (pac[z].equals(cur[x])){
                        found = true;
                    }
                }
                if (found==false){
                    cur[x]="xxx";
                    break;
                }
            }
            //if ((found==true)&(!cur[x].equals("xxx"))){
            if (found==true){
                eleme.add(cur[x]);
            }
        }
        Collections.sort(eleme);
        String[] fina = new String[eleme.size()];
        for (int p =0; p < eleme.size(); p++){
            fina[p] = eleme.get(p);
        }
        //StringBuilder phanta = new StringBuilder();
        //for
        String retu = String.join(" ",eleme);
        return retu;
    }
}
