public class recursiveaddEveryOther {
    public static void recursiveaddEveryOther(ListNode list, int value){
        ListNode first = list;
        if(list!= null) {
            int p = list.info;
            p += value;
            list.info = p;
            ListNode again = list.next.next;
            System.out.println(list.info);
            if (again != null) {
                recursiveaddEveryOther(again, value);
            }
        }
    }

    public static void main(String[] args){
        ListNode test = new ListNode(9, null);
        test.next = new ListNode(3, null);
        test.next.next = new ListNode(7, null);
        test.next.next.next = new ListNode(4, null);
        test.next.next.next.next = new ListNode(2,null);
        test.next.next.next.next.next = new ListNode(5, null);
        recursiveaddEveryOther(test, 4);
    }
}

