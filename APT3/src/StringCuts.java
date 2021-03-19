import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class StringCuts {
    public String[] filter(String[] list, int minLength){
        list = new LinkedHashSet<String>(Arrays.asList(list)).toArray(new String[0]);
        //ArrayList<String> inter = new ArrayList<String>(Arrays.asList(list));
        int counver = 0;
        for(int x = 0; x< list.length; x++){
            if(list[x].length() >= minLength){
                //inter.remove(new String(list[x]));
                counver += 1;
            }
            else{
                list[x] = "xxx";
            }
        }
        //String[] fina = new String[inter.size()];
        String[] fina = new String[counver];
        int intern = 0;
        for(int x =0; x<list.length; x++){
            if (list[x].equals("xxx")){
                continue;
            }
            else{
                fina[intern] = list[x];
                intern += 1;
            }
        }
//        for(int x = 0; x < inter.size(); x++){
//            fina[x] = inter.get(x);
//        }
        return fina;
    }
}
