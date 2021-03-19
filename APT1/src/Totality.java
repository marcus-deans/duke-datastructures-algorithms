public class Totality {
    public int sum(int[] a, String stype) {
        int countit = 0;
        if (stype.equals("even")){
            for (int x = 0; x< a.length; x+=2) {
                countit += a[x];
            }
        }
        if (stype.equals("odd")){
            for (int x = 1; x< (a.length); x+=2) {
                countit += a[x];
            }
        }
        if (stype.equals("all")){
            for (int x = 0; x< a.length; x++) {
                countit += a[x];
            }
        }
        return countit;
    }
}
