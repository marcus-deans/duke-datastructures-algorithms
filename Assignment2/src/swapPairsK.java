public class swapPairsK {
    public static void swapPairsK(ListNode list, int k, boolean swap){
        ListNode first = list;
        if((list.info >= k)&&(list.next!=null)){
            swap = true;
            swapPairs(list);
        }
        if((!swap)&&(list.next != null)){
            swapPairsK(list.next, k, swap);
        }
    }
    public static void swapPairs(ListNode list){
        ListNode first = list;
        int evenodd = 2;
        int alpha = 0;
        int bravo = 0;
        while(list != null){
            evenodd += 1;
            if((evenodd % 2 == 1)&&(list.next != null)){
                alpha = list.info;
                bravo = list.next.info;
                list.info = bravo;
                list.next.info = alpha;
            }
            list = list.next;
        }
    }

    public static void main(String[] args){
        ListNode test = new ListNode(4, null);
        ListNode result = test;
        test.next = new ListNode(3, null);
        test.next.next = new ListNode(7, null);
        test.next.next.next = new ListNode(9, null);
        test.next.next.next.next = new ListNode(2,null);
        test.next.next.next.next.next = new ListNode(5,null);
        test.next.next.next.next.next.next = new ListNode(11,null);
        test.next.next.next.next.next.next.next = new ListNode(6, null);
        test.next.next.next.next.next.next.next.next = new ListNode(8, null);
        swapPairsK(test, 9, false);
        while(result != null){
            System.out.println(result.info);
            result=result.next;
        }
    }
}
