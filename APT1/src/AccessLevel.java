public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        char[]pri = new char[rights.length];
        for (int x=0; x < rights.length; x++){
            if (rights[x] >= minPermission){
                pri[x] = 'A';
            }
            else {
                pri[x] = 'D';
            }
        }
        String fina = new String(pri);
        return fina;
    }
}