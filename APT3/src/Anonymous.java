import java.util.ArrayList;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        int fina = 0;
        for (int x =0; x<messages.length; x++){
            int[] meslet = getCounts(messages[x].split(" "));
            ArrayList<String> allhead = new ArrayList<>();
            for (int y =0; y<headlines.length; y++) {
                String[] thishead = headlines[y].split(" ");
                for (int z = 0; z < thishead.length; z++) {
                    allhead.add(thishead[z]);
                }
            }
            String[] combihead = allhead.toArray(new String[0]);
            int[]headlet = getCounts(combihead);
            boolean curhead = true;
            for (int c = 97; c<meslet.length; c++){
                if (meslet[c] > headlet[c]){
                    curhead = false;
                }
            }
            if(curhead){
                fina += 1;
            }

        }
        return fina;
    }
    private int[] getCounts(String[] strings){
        int[] counts = new int[300];
        for(String s : strings){
            for(char ch : s.toLowerCase().toCharArray()){
                counts[ch] += 1;
            }
        }
        return counts;
    }
}
//        int numgood = 0;
//        for (int x = 0; x<messages.length; x++){
//            ArrayList<Character> messy = new ArrayList<>();
//            String[] messa= messages[x].split(" ");
//            for (int a = 0; a< messa.length; a++){
//                String messaword = messa[a];
//                for (int b = 0; b< messaword.length(); b++){
//                    messy.add(messaword.charAt(b));
//                }
//            }
//            for (int y = 0; y<headlines.length;y++){
//                ArrayList<Character> heady = new ArrayList<>();
//                String[] head = headlines[y].split(" ");
//                for (int c = 0; c<head.length; c++){
//                    String headword = head[c];
//                    for (int d = 0; d<headword.length(); d++){
//                        heady.add(headword.charAt(d));
//                    }
//                }
//                boolean charfound;
//                boolean wordfound = true;
//                for(int e = 0;e<messy.size(); e++){
//                    charfound = false;
//                    for(int f = 0; f< heady.size(); f++){
//                        if((messy.get(e)==heady.get(f))&&(heady.get(f)!='%')){
//                            //heady.pop
//                            //heady(f)="%"
//                            charfound = true;
//                            heady.set(f,'%');
//                            break;
//                        }
//                    }
//                    if (!charfound){
//                        wordfound = false;
//                        break;
//                    }
//                }
//                if (wordfound){
//                    numgood += 1;
//                }
//            }
//        }
//        return numgood;
//    }
//}
