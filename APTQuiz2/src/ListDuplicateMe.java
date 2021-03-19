public class ListDuplicateMe {
    public ListNode duplicate(ListNode list){
        if (list == null){
            return null;
        }
        ListNode front = list;
        while(list != null){
            int recurrence = list.info;
            for(int x = 1; x < recurrence; x++){
                ListNode temp = list.next;
                list.next = new ListNode(list.info, temp);
                list = list.next;
            }
            list = list.next;
        }
        return front;
    }
}
