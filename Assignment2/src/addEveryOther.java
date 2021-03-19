public class addEveryOther {
    public static ListNode addEveryOther(ListNode list, int value) {
        ListNode first = list;
        if (list == null) {
            return null;
        }
        int evenodd = 2;
        int zur = 0;
        while (list != null) {
            evenodd += 1;
            if (evenodd % 2 == 1) {
                zur = list.info;
                zur += value;
                list.info = zur;
            }
            list = list.next;
        }

        return first;
    }

    public static void main(String[] args){
        ListNode test = new ListNode(9, null);
        test.next = new ListNode(3, null);
        test.next.next = new ListNode(7, null);
        test.next.next.next = new ListNode(4, null);
        test.next.next.next.next = new ListNode(2,null);
        test.next.next.next.next.next = new ListNode(5, null);
        ListNode result = addEveryOther(test, 4);
        while(result != null){
            System.out.println(result.info);
            result=result.next;
        }
    }
}
