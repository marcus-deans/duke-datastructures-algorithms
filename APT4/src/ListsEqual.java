public class ListsEqual {
    public int equal (ListNode a1, ListNode a2){
        int fina = 0;
        while (a1!=null && a2 != null){
            if (a1.info != a2.info){
                return 0;
            }
            a1 = a1.next;
            a2 = a2.next;
//            if ((a1==null)||(a2==null)){
//                fina = 0;
//                break;
//            }
        }
        if (a1 == null && a2 == null){
            fina = 1;
        }
        return fina;
    }
}
