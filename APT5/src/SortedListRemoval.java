public class SortedListRemoval {
    public ListNode uniqify(ListNode list){
        // write code here
//        tamp(list);
        if(list == null){
            return null;
        }
        ListNode first = list;
        while(first != null){
//            if(first.info == first.next.info){
//                ListNode atemp = first;
//                ListNode temp = first.next.next;
//                if(temp == null){
//                    atemp.next = null;
//                }
//                else{
////                    first.next = null;
//                    atemp.next = temp;
//                }
//            }
            ListNode tempt = first;
            while(tempt!=null && tempt.info==first.info){
                tempt = tempt.next;
            }
            first.next = tempt;
            first = first.next;
        }
        return list;
    }
//    public void tamp(ListNode meh){
//        ListNode first = meh;
//        while(first.next != null){
//            if(first.info == first.next.info){
//                if(first.next.next != null){
//                    first.next = null;
//                }
//                else{
//                    first.next = first.next.next;
//                }
//            }
//            first = first.next;
//        }
//    }
}
