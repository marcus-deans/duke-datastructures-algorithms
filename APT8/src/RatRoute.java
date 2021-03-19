public class RatRoute {

    char[][] myBoard;
    int myCheeseRow;
    int myCheeseCol;
    //also from lecture
    public int numRoutes(String[] enc){
        int ratRow = 0;
        int ratCol = 0;
        myBoard = new char[enc.length][enc[0].length()];
        for(int r = 0; r < myBoard.length; r++){
            for(int c =0; c< myBoard[0].length; c++){
                myBoard[r][c] = enc[r].charAt(c);
                if(myBoard[r][c] == 'R'){
                    ratRow = r;
                    ratCol = c;
                }
                else if (myBoard[r][c] == 'C'){
                    myCheeseRow = r;
                    myCheeseCol = c;
                }
            }
        }
        return moveCount(ratRow, ratCol);
    }
    //from lecture
    private int moveCount(int r, int c){
        if(r < 0 || c < 0|| r>= myBoard.length || c >= myBoard[0].length){
            return 0;
        }
        if (myBoard[r][c] == 'X'){
            return 0;
        }
        if(myBoard[r][c] == 'C'){
            return 1;
        }
//        if (r == myCheeseRow && c == myCheeseCol){
//            return 1;
//        }
        double distanceNow = cheeseDistance(r,c);
//        int[] deltaRow = {-1, 0, 0, 1};
        int[] deltaRow = {1, -1, 0, 0};
//        int[] deltaCol = {0, -1, 1, 0};
        int[] deltaCol = {0, 0, 1, -1};
        int total = 0;

        for(int k= 0; k < deltaRow.length; k++){
            int nr = r + deltaRow[k];
            int nc = c + deltaCol[k];
            if (cheeseDistance(nr, nc) < distanceNow){
                int next = moveCount(nr, nc);
                total += next;
            }
        }
        return total;
    }
    //only part added
    public double cheeseDistance(int row, int col){
        return Math.sqrt(Math.pow((row-myCheeseRow),2)+Math.pow(col-myCheeseCol, 2));
    }
}
