public class ListLastFirst {
    public ListNode move(ListNode list){
        if(list == null || list.next == null){
            return list;
        }
        ListNode prev = null;
        ListNode last = list;

        while(last.next != null){
            prev=  last;
            last = last.next;
        }
        prev.next = null;
        last.next = list;
        list = last;
        return list;
    }
}
