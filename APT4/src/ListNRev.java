import java.util.ArrayList;

public class ListNRev {
    public ListNode make(int n){
        ArrayList<Integer> values  = new ArrayList<Integer>();
        for(int p = n; p > 0; p-=1){
            for(int z = 0; z<p; z++){
                values.add(p);
            }
        }
        ListNode meh = new ListNode(n);
        ListNode exten = meh;
        for(int t = 1; t<values.size(); t++){
            meh.next = new ListNode(values.get(t), meh.next);
            meh = meh.next;
        }
//        exten = new ListNode(0);
////        ListNode ffront = exten;
//        for(int k=1; k <= n; k++){
//            for(int j=0; j<k; j++){
////                exten = new ListNode (n-j, exten.next);
//                exten = new ListNode(n-j);
////                exten.next = new ListNode(k, exten.next);
//                exten = exten.next;
//            }
//        }
        return exten;
    }
}
