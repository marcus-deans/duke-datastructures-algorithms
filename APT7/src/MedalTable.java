import java.util.*;

public class MedalTable {

    //implements Comparable<Person>
    public class Country {
        int myGold;
        int mySilver;
        int myBronze;
        String myName;
        public Country(String name, int gold, int silver, int bronze) {
            myName = name;
            myGold = gold;
            mySilver = silver;
            myBronze = bronze;
        }

        public int getGold() {
            return myGold;
        }

        public int getSilver() {
            return mySilver;
        }

        public int getBronze(){
            return myBronze;
        }

        public String getName(){
            return myName;
        }

    }
    public String xString(Country curren){
//            for(int k =0; k<list.length; k++){
//                values[k] = list[k].getFirst() + " " + list[k].getLast();
//            }
        return curren.getName() + " " + curren.getGold() + " " + curren.getSilver() + " " + curren.getBronze();
    }
//        @Override
//        public int compareTo(Person o) {
//            return 0;
//        }

    public String[] generate(String[] results){
        HashSet<String> allcountries = new HashSet<>();
        ArrayList<String> allgold = new ArrayList<>();
        ArrayList<String> allsilver = new ArrayList<>();
        ArrayList<String> allbronze = new ArrayList<>();

        for(String x : results){
            String[] eventresult = x.split(" ");
            allcountries.addAll(Arrays.asList(eventresult));
            allgold.add(eventresult[0]);
            allsilver.add(eventresult[1]);
            allbronze.add(eventresult[2]);
        }
        ArrayList<String> countrylist = new ArrayList<>(allcountries);
        Country[] list = new Country[countrylist.size()];
        int coun = 0;
        for(String i : countrylist){
            list[coun] = new Country(i, Collections.frequency(allgold,i), Collections.frequency(allsilver,i), Collections.frequency(allbronze,i));
            coun ++;
        }

//        for(String p : results){
//
//            if(p.contains(",")){
//                String[] curinfo = p.split(", ");
//                list[coun] = new Person(curinfo[1], curinfo[0]);
//            }
//            else{
//                String[] xinfo = p.split(" ");
//                list[coun] = new Person(xinfo[0], xinfo[1]);
//            }
//            coun++;
//        }

        Arrays.sort(list,
                Comparator.comparingInt(Country::getGold).reversed()
                .thenComparing(Country::getSilver, Comparator.reverseOrder())
                .thenComparing(Country::getBronze, Comparator.reverseOrder())
                .thenComparing(Country::getName));
        String[] fina = new String[list.length];
        for(int k=0; k<countrylist.size(); k++){
            fina[k]  = xString(list[k]);
        }
        return fina;
        //translate into Person format, then translate back for output
    }

}
