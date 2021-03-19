/**
 * Percolation DFSFast improves on performance of PercolationDFS by optimizing the dfs method
 * Rather than clear the grid each time, it only performs the dfs function on cells that are
 * actually open
 */
public class PercolationDFSFast extends PercolationDFS{
    /**
     * Inherits methods and functions of PercolationDFS via super
     * @param order initialization call for PercolationDFS
     */
    public PercolationDFSFast(int order) {
        super(order);
    }

    /**
     * Override updateOnOpen to make more efficient
     * Instead of checking all grid, check neighbours
     * and if cell is in top row
     * @param row integer row of current cell to be examined
     * @param col integer column of current cell to be examined
     */
    @Override
    protected void updateOnOpen(int row, int col) {
//        clearFull();
//        for (int k = 0; k < myGrid[0].length; k++)
//            dfs(0, k);
        boolean clea = false;
        if(row == 0){
            clea=true;
        }
        if(inBounds(row+1,col)){
            if(myGrid[row+1][col] == FULL){
                clea = true;
            }
        }
        if(inBounds(row-1,col)){
            if(myGrid[row-1][col] == FULL){
                clea = true;
            }
        }
        if(inBounds(row,col+1)){
            if(myGrid[row][col+1] == FULL){
                clea = true;
            }
        }
        if(inBounds(row,col-1)){
            if(myGrid[row][col-1] == FULL){
                clea = true;
            }
        }
        if(clea){
            dfs(row,col);
        }
    }
}