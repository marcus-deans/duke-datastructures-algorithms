public class RemoveLast {
    public ListNode remove (ListNode list){

        if (list == null){
            return null;
        }
        if (list.next == null) {
            return null;
        }
        ListNode bravo = list;
        while(bravo.next.next != null){
            bravo = bravo.next;
        }
        bravo.next = null;
        return list;
    }
}
