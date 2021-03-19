public class ListSum {
    public int sum(ListNode list, int thresh){
        int fina = 0;
        int iter = 0;
        while (list != null){
            if(list.info > thresh){
                fina += list.info;
            }
            list = list.next;
        }
        return fina;
    }
}
