public class RemoveMin {
    public ListNode remove (ListNode list) {
        int max = 0;
        int cur = 0;
        ListNode maxer = list;
        max = maxer.info;
        while (maxer != null){ //finds minimum value within list
            cur = maxer.info;
            if (cur < max){
                max = cur;
            }
            maxer = maxer.next;
        }
        ListNode help = new ListNode(0);
        help.next = list;
        ListNode y = help;
        while(y.next != null){
            if(y.next.info == max){
                ListNode next = y.next;
                y.next = next.next;
            }
            else{
                y = y.next;
            }
        }
        return help.next;
    }
}
