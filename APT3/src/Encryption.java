import java.util.ArrayList;
import java.util.HashMap;

public class Encryption {
    public String encrypt(String message) {

        HashMap<Character, Character> conver = new HashMap<>();
        char[] origin = new char[message.length()];
        for (int x = 0; x < message.length(); x++) {
            origin[x] = message.charAt(x);
        }
        int lett = 97;
        for (int x = 0; x < origin.length; x++) {
            if (conver.containsKey(origin[x])) {
                origin[x] = conver.get(origin[x]);
            }
            else {
                conver.put(origin[x], (char) lett);
                origin[x] = (char) lett;
                lett += 1;
            }
        }
        return new String(origin);
    }
}

//        int[] conver = new int[origin.length];
//        for(int y=0; y<origin.length; y++){
//            conver[y] = (int)origin[y];
//        }
//        ArrayList<Integer>  utile = new ArrayList<>();
//        for(int z = 0; z<conver.length; z++){
//            boolean found = false;
//            for(int p = 0; p< utile.size(); p++){
//                if(utile.get(p)==conver[z]){
//                    found = true;
//                    break;
//                }
//            }
//            if((found=false){
//                conver[z]=
//            }
//        }
//        int ratio = conver[0]-97;
//        for(int z=0; z<origin.length; z++){
//            conver[z] = (conver[z]-ratio);
//        }
//        char[] resul = new char[origin.length];
//        for(int p=0; p < origin.length; p++){
//            resul[p] = (char)conver[p];
//        }
//        return new String(resul);
        // you write code here
//    }
//}
