import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
    //implements Comparable<Person>
    public class Person {
        String myFirst;
        String myLast;

        public Person(String fname, String lname) {
            myFirst = fname;
            myLast = lname;
        }

        public String getFirst() {
            return myFirst;
        }

        public String getLast() {
            return myLast;
        }

//        @Override

    }
    public String xString(Person curren){
//            for(int k =0; k<list.length; k++){
//                values[k] = list[k].getFirst() + " " + list[k].getLast();
//            }
        return curren.getFirst() + " " + curren.getLast();
    }
//        @Override
//        public int compareTo(Person o) {
//            return 0;
//        }

    public String[] dataCleanup(String[] names){
        Person[] list = new Person[names.length];
        int coun = 0;
        for(String p : names){
            if(p.contains(",")){
                String[] curinfo = p.split(", ");
                list[coun] = new Person(curinfo[1], curinfo[0]);
            }
            else{
                String[] xinfo = p.split(" ");
                list[coun] = new Person(xinfo[0], xinfo[1]);
            }
            coun++;
        }
        Arrays.sort(list, Comparator.comparing(Person::getLast).thenComparing(Person::getFirst));
//        String[] fina = new String[list.length];
        for(int k=0; k<names.length; k++){
            names[k]  = xString(list[k]);
        }
        return names;
        //translate into Person format, then translate back for output
    }
}
