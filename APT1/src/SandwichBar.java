public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
        int inde = -1;
        for (int x = 0; x < orders.length; x++){
            boolean orderPass = true;
            String anOrder = orders[x];
            String[] orderItems = anOrder.split(" ", 0);
            for (int z = 0; z < orderItems.length; z ++) {
                boolean anItem = false;
                for (int y = 0; y < available.length; y++) {
                    if (orderItems[z].equals(available[y])){
                        anItem = true;
                        break;
                    }
                }
                if (anItem == false){
                    orderPass = false;
                    break;
                }
            }
            if (orderPass == true){
                inde = x;
                break;
            }
        }

        return inde;
    }
}
