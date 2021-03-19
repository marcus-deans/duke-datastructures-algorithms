import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Dirsort {
    public class LengthFirstComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if(lengthval(o1)!=lengthval(o2)){
                return lengthval(o1)-lengthval(o2);
            }
            return o1.compareTo(o2);
        }
    }
    public String[] sort(String[] dirs) {
//        TreeMap<String, Integer> map = new TreeMap<>();
//        for (String x : values) {
//            map.put(x, x.length());
//        }
//        ArrayList<String> list = new ArrayList<>(map.keySet());
//        Comparator<String> comp = Comparator.comparingInt(s -> map.get(s))
//                .thenComparing(s -> redundant.get(s));
//                .thenComparing(s -> list.get(s));
//        list.sort(comp.reversed());
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(dirs));
        Collections.sort(list, new LengthFirstComparator());
        String[] fina = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            fina[x] = list.get(x);
        }
        return fina;
    }

    public int lengthval(String evaluate){
        String[] charlie = evaluate.split("/");
        return charlie.length;
    }
}
