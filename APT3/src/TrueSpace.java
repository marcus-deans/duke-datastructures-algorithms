public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        // fill in code here
        long outpu = 0;
        int curren;
        for (int x = 0; x<sizes.length; x++){
            curren = sizes[x]/clusterSize;
            if((sizes[x]%clusterSize)!=0){
                curren += 1;
            }
            outpu += curren;
        }
        return outpu*clusterSize;
    }
}
