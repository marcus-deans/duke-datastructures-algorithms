import java.util.ArrayList;

public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        ListNode nfront = list;
        ListNode alter = list;
//        ListNode cur = new ListNode(list.info);
        int cur;
//        ArrayList<Integer> meh = new ArrayList<>();
//        while(alter != null){
//            meh.add(alter.info);
//            alter = alter.next;
//        }

        while(list != null){
//            cur = alter.info;
            for (int p = 0; p<amount-1; p++){
//                list.next = new ListNode(alter.info);
//                list = list.next;
                list.next = new ListNode(list.info, list.next);
                list = list.next;
//                alter = alter.next;
//                alter.next = new ListNode(list.info, alter.next);
//                list.next = new ListNode(cur, list.next);
//                alter = alter.next.next;
//                list.next=
            }
//            alter = alter.next;
            list = list.next;
        }
        return nfront;
//        ListNode nFront = list;
//        while (list != null) {
//            list.next = new ListNode(list.info, list.next);
//            list = list.next.next;
//        }
//        return nFront;
    }

}
