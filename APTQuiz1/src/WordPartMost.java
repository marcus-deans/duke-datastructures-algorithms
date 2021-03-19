import java.util.ArrayList;
import java.util.HashMap;

public class WordPartMost {
    public int most(int number, String[] words){
        ArrayList<String> allsub = new ArrayList<String>(0);
        for (int x = 0; x<words.length; x++) {
            String curword = words[x];
//            for (int start = 0; start < curword.length(); start += number){
//                String tsub = (curword.substring(start, Math.min(curword.length(), start + number)));
//            if (tsub.length() == number){
//                allsub.add(tsub);
//            }
            for (int i = 0; i < curword.length(); i = i + 1) {
                String tsub = curword.substring(i, Math.min(i + number, curword.length()));
//                System.out.println(tsub);
                if (tsub.length() == number){
                    allsub.add(tsub);
                }
            }
        }
        HashMap<String, Integer> quan = new HashMap<String, Integer>(0);
        int curquan = 0;
        int maxcount = 0;
        for (int z = 0; z<allsub.size(); z++){
            quan.put(allsub.get(z), 0);
        }
        for (int y = 0; y<allsub.size(); y++){
            String cursub = allsub.get(y);
            curquan = quan.get(cursub);
            int newquan = curquan+1;
            quan.put(cursub, newquan);
            if(newquan> maxcount){
                maxcount = newquan;
            }
        }
//        for (int p = 0; p<allsub.size(); p++){
//            if(quan.get(allsub[p])>maxcount){
//
//            }
//        }
        return maxcount;
    }
}
