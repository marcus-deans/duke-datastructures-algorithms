public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2){
        int count = 0;
        for (int p = 0; p < x.length; p++){
            boolean first = isInside(x[p],y[p],x1,y1,r[p]);
            boolean second = isInside(x[p],y[p],x2,y2,r[p]);
            if (first!=second){
                count += 1;
            }
        }
                //for loop to run
        // calculate two distances (e and f)
         // e != f; then add one to counter
        return count;
    }

    public boolean isInside(int x, int y, int cx, int cy, int r){
        double dist = (x-cx)*(x-cx) + (y-cy)*(y-cy);
        double radSquared = r*r;
        return dist < radSquared;
    }
}
