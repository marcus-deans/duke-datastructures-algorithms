import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data){
        TreeMap<String, Integer> map = new TreeMap<>();
        for(String s : data) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
//        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list,
//                Collections.reverseOrder(
//                        Comparator.comparing(
//                                Map.Entry::getValue)));\
        //sort b y frequency
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Comparator<String> comp = Comparator.comparingInt(s -> map.get(s));
        list.sort(comp.reversed());

//        String[] fina = new String[list.size()];
//        for(int x = 0; x < list.size(); x++){
//            fina[x] = list.get(x);
//        }
//        return new String[0];
        return list.toArray(new String[0]);
//        String[] fina = new String[map.size()];
//        int index = 0;
//        for(String s : set){
//            ret[index] = Collections.frequency(Arrays.asList(data), s);
//            index++;
//        }
    }
}
