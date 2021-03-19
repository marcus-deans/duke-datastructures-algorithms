import java.util.ArrayList;

public class AddSome {
    public ListNode splice(ListNode list, int size){
        ListNode nfront = list;
        ListNode nef = null;

        ArrayList<Integer> alter = new ArrayList<>();
//        if(list.info == 1 && list.next.info == 2){
//            list.next = new ListNode(1, list.next);
//            return list;
//        }
//        for(int p =1; p <= size; p++){
//            alter.add(list.info);
//            list = list.next;
//        }
        while(list!= null){
            alter.add(list.info);
            list = list.next;
        }
        nef = new ListNode(alter.get(0));
        ListNode ffront = nef;
        for(int p = 0; p < 2; p++){
            for(int z = 1; z<size; z++){
                nef.next = new ListNode(alter.get(z), nef.next);
//                nef = new ListNode(alter.get(z));
                nef = nef.next;
            }
            if(p==0){
                nef.next = new ListNode(alter.get(0), nef.next);
                nef = nef.next;
            }
        }
        for(int y = size; y<alter.size(); y++){
            nef.next = new ListNode(alter.get(y), nef.next);
            nef = nef.next;
        }
//        nef.next = new ListNode(alter.get(size), nef.next);
//        nef.next = new ListNode(alter.get(size));
//        nef = nef.next;
//        for(int x = 1; x <= size; x++){
//            list.next = new ListNode(alter.get(x), list.next);
//            list = list.next;
//        }

//        for(int x = 1; x <= size; x++){
//            ListNode cur = list;
//            final;
//            for(int p = 1; p<= size; p+++){
//                cur = cur.next;
//            }
//            charlie.next = charlie.next.next;
//        }
        return ffront;
//        ListNode nFront = list;
//        while (list != null) {
//            list.next = new ListNode(list.info, list.next);
//            list = list.next.next;
//        }
//        return nFront;
    }
}
