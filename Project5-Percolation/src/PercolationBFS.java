import java.util.LinkedList;
import java.util.Queue;

/**
 * PercolationBFS uses an alternative version of methods dfs that uses
 * a queue instead of recursion
 */
public class PercolationBFS extends PercolationDFSFast{
    /**
     * Inherits methods and functions from PercolationDFSFast and thus
     * PercolationDFS by extension
     * @param order initialisation call for PercolationDFSFast
     */
    public PercolationBFS(int order){
        super(order);
    }

    /**
     * Private helper method to mark all cells that are open and reachable from
     * (row,col).
     * This version of dfs uses a queue as opposed to the original recrusion
     * @param row is the row coordinate of the cell being checked/marked
     * @param col is the col coordinate of the cell being checked/marked
     */
    @Override
    protected void dfs(int row, int col) {
        // out of bounds?
        if (! inBounds(row,col)) return;

        // full or NOT open, don't process
        if (isFull(row, col) || !isOpen(row, col))
            return;

        Queue<Integer> qi = new LinkedList<>();

        myGrid[row][col] = FULL;
        qi.add(row*(myGrid.length)+col);
        int[] rowl = {-1,1,0,0};
        int[] coll = {0,0,-1,1};

        while(qi.size() != 0){
            int i = qi.remove();
            int rowi = i/(myGrid.length);
            int coli = i%(myGrid.length);
            for(int k=0; k<rowl.length; k++){
                int rowcur = rowi + rowl[k];
                int colcur = coli + coll[k];
                if(inBounds(rowcur,colcur) && !isFull(rowcur, colcur) && isOpen(rowcur, colcur)){
                    myGrid[rowcur][colcur] = FULL;
                    qi.add(rowcur*(myGrid.length)+colcur);
                }
            }
        }
//        dfs(row - 1, col);
//        dfs(row, col - 1);
//        dfs(row, col + 1);
//        dfs(row + 1, col);
    }
}
