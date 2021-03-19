public class ListCount {
    public int count (ListNode list){
        int fina = 0;
//        int iter = 0;
        while (list != null){
            fina += 1;
            list = list.next;
        }
        return fina;
    }
}
