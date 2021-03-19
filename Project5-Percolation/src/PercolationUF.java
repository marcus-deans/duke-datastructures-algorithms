import java.util.Arrays;

/**
 * PercolationUF uses union sets to more efficiently perform the percolation analysis
 */
public class PercolationUF implements IPercolate{
    /**
     * Declare instance variables
     */
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    /**
     * Constructor initialize PercolationUF and instance variables
     * @param finder IUnionFind that will be used to identify set unions
     * @param size integer size of grid that will also be used in variable initialisation
     */
    public PercolationUF(IUnionFind finder, int size){
        myGrid = new boolean[size][size];
        finder.initialize(size*size + 2);
        myFinder = finder;
        VTOP = size*size;
        VBOTTOM = size*size + 1;
        myOpenCount = 0;
    }

    /**
     * Open site (row, col) if it is not already open. By convention, (0, 0)
     * is the upper-left site
     * If current cell is out of bounds, throw exception
     * If in top row, then call myFinder.union to combine with VTOP (ie. with water)
     * If in bottom row, then call myFinder.union to combine with VBOTTOM (ie. target destination)
     * In addition, check all four neighbours
     * If neighbour is in bounds and open, call myFinder.union to combine current cell and neighbour
     * @param row row index in range [0,N-1]
     * @param col column index in range [0,N-1]
     */
    @Override
    public void open(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if(isOpen(row,col)){
            return;
        }
        myGrid[row][col] = true;
        myOpenCount ++;
        if(row == 0){
            myFinder.union(row*(myGrid.length)+col, VTOP);
        }
        if(row == myGrid.length-1){
            myFinder.union(row*(myGrid.length)+col,VBOTTOM);
        }
        if(inBounds(row+1,col) && isOpen(row+1,col)){
            myFinder.union(row*(myGrid.length)+col, (row+1)*(myGrid.length)+col);
        }
        if(inBounds(row-1,col) && isOpen(row-1,col)){
            myFinder.union(row*(myGrid.length)+col, (row-1)*(myGrid.length)+col);
        }
        if(inBounds(row,col+1) && isOpen(row,col+1)){
            myFinder.union(row*(myGrid.length)+col, (row)*(myGrid.length)+col+1);
        }
        if(inBounds(row,col-1) && isOpen(row,col-1)){
            myFinder.union(row*(myGrid.length)+col, (row)*(myGrid.length)+col-1);
        }
    }

    /**
     * Returns true if and only if site (row, col) is OPEN
     * @param row integer row index in range [0,N-1]
     * @param col integer column index in range [0,N-1]
     */
    @Override
    public boolean isOpen(int row, int col){
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        return myGrid[row][col];
    }

    /**
     * Returns true if and only if site (row, col) is FULL (implied by being connected with VTOP)
     * @param row row index in range [0,N-1]
     * @param col column index in range [0,N-1]
     */
    @Override
    public boolean isFull(int row, int col){
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        return myFinder.connected(row*(myGrid.length)+col,VTOP);
    }

    /**
     * Returns true if the simulated percolation actually percolates. What it
     * means to percolate could depend on the system being simulated, but
     * returning true typically means there's a connected path from
     * top-to-bottom.
     * This is determined if VTOP and VBOTTOM are found to be connectd by myFinder.connected
     * @return true iff the simulated system percolates
     */
    @Override
    public boolean percolates(){
//        for (int col = 0; col < myGrid[myGrid.length - 1].length; col++)
//            if (isFull(myGrid.length - 1, col))
//                return true;
//        return false;
        return myFinder.connected(VTOP,VBOTTOM);
    }

    /**
     * Returns the number of distinct sites that have been opened in this
     * simulation
     * @return number of open sites
     */
    @Override
    public int numberOfOpenSites(){
        return myOpenCount;
    }

    /**
     * Determine if (row,col) is valid for given grid
     * @param row specifies row
     * @param col specifies column
     * @return true if (row,col) on grid, false otherwise
     */
    protected boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }
}
