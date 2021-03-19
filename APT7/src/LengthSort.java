import java.util.*;

public class LengthSort {

    public class LengthFirstComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(o1.length()!=o2.length()){
                return o1.length()-o2.length();
            }
            return o1.compareTo(o2);
        }
    }
    public String[] rearrange(String[] values) {
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
        list.addAll(Arrays.asList(values));
        Collections.sort(list, new LengthFirstComparator());
        String[] fina = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            fina[x] = list.get(x);
        }
        return fina;
    }
}
