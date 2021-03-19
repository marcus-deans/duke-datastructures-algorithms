import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairDown {
    public int[] fold(int[] list) {
        ArrayList<Integer> larg = new ArrayList<Integer>();
        if (((list.length)%2)==1){
            int[] nlist = new int[(list.length)+1];
            for(int x=0; x < list.length; x++){
                nlist[x] = list[x];
            }
            nlist[(list.length)] = 0;
            for(int y = 0; y< (nlist.length)-1; y+=2){
                larg.add(nlist[y]+nlist[y+1]);
            }
        }
        else{
            for(int y = 0; y< (list.length)-1; y+=2){
                larg.add(list[y]+list[y+1]);
            }
        }
        int[] outp = new int[larg.size()];
        for (int x =0; x < outp.length; x++){
            outp[x] = larg.get(x);
        }
        return outp;
    }
}
