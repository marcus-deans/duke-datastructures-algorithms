public class ListNode {
    int info;
    ListNode next;
    ListNode(int val){
        info = val;
    }
    ListNode(int val, ListNode link){
        info = val;
        next = link;
    }
}
