public class ListSumLast {
    public int lastk(ListNode list, int k){
        ListNode counter = list;
        int lengt = 0;
        if(list == null){
            return 0;
        }
        while(counter != null){
            lengt++;
            counter = counter.next;
        }
        for(int x = 0; x < lengt-k; x++){
            list=list.next;
        }
        int count = 0;
//        list = list.next;
        for(int x = lengt-k; x<lengt; x++){
            count += list.info;
            if(list.next == null){
                break;
            }
            list = list.next;
        }
        return count;
    }
}
