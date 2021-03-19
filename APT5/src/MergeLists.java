public class MergeLists {
    public ListNode weave (ListNode a, ListNode b){
        ListNode alpha = a;
        ListNode bravo = b;
        ListNode fina = a;
        ListNode charlie = fina;
        int x = 2;
        alpha = alpha.next;
        while(bravo != null){
            x++;
            if(x%2==0){
                charlie.next = alpha;
                alpha = alpha.next;
            }
            else{
                charlie.next = bravo;
                bravo = bravo.next;
            }
            charlie = charlie.next;
        }
        return fina;
    }
}
