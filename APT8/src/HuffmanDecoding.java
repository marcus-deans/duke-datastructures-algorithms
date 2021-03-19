import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary){
        //
        boolean epislon = true;
        int charlie = 3;
        Map<String, Character> newMap = new HashMap<>();
        int currentLen = 0;
        ArrayList<String> arlist = new ArrayList<>();
        epislon = false;
        boolean delta = true;
        for(int x = 0; x < dictionary.length; x ++){
            int asciiNum = 65 + x;
            Character curLet = (char) asciiNum;
            newMap.put(dictionary[x], curLet);
        }
        delta = false;
        while(currentLen< archive.length()){
            for(int p =0;p<dictionary.length;p++){
                String currenLet = dictionary[p];
                int archiveLength = archive.length() + 1;
                if(currentLen+currenLet.length() < archiveLength){
                    String currentSubString = archive.substring(currentLen, currentLen + currenLet.length());
                    if(currentSubString.equals(currenLet)){
                        arlist.add(Character.toString(newMap.get(currentSubString)));
                        currentLen += currenLet.length();
                    }
                }
            }
        }
        return String.join("",arlist);
    }
}
