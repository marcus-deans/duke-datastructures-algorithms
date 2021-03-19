import java.util.*;

public class TheBestName {
    public class LengthFirstComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(nameval(o1)!=nameval(o2)){
                return nameval(o2)-nameval(o1);
            }
            return o1.compareTo(o2);
        }
    }
    public String[] sort(String[] names){
        HashMap<String, Integer>  map = new HashMap<>();
        boolean johnny = false;
        int johnnycount = 0;
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> tigre = new ArrayList<>();
        for(String x : names){
            if(x.equals("JOHN")){
                johnny = true;
                johnnycount += 1;
                inter.add("JOHN");
            }
            else{
                map.put(x,nameval(x));
                tigre.add(x);
            }
        }
//        HashMap<Object, Object> redundant = new HashMap<>();
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(tigre, new LengthFirstComparator());
//        for(String x: list){
//            redundant.put(x,x);
//        }
//        Comparator<String> comp = Comparator.comparingInt(s -> map.get(s))
//                .thenComparing(s -> redundant.get(s));
//                .thenComparing(s -> list.get(s));
//        list.sort(comp.reversed());

        String[] fina = new String[inter.size() + tigre.size()];
        for (int z = 0; z < johnnycount; z++){
            fina[z] = inter.get(z);
        }
        for (int x = 0; x < tigre.size(); x++){
            fina[x+johnnycount] = tigre.get(x);
        }
        return fina;
    }

    public int nameval(String in){
        int count = 0;
        for(int x = 0; x < in.length(); x++){
            count += ((int)in.charAt(x)) - 64;
        }
        return count;
    }
}
