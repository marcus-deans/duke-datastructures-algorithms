public class GridGame {
    public int winningMoves(String[] grid){
        char[][] checker = makeNewGrid(grid);
        return winCount(checker);
    }
    public boolean canMove(char[][] inboard, int row, int col){
        Character checkval = inboard[row][col];
        boolean response = true;
        if (checkval == 'X'){
            response = false;
        }
        if (col < 3){
            Character alter = inboard[row][col+1];
            if(alter == 'X'){
                response = false;
            }
        }
        if (col > 0){
            Character alter = inboard[row][col-1];
            if(alter == 'X'){
                response = false;
            }
        }
        if (row < 3){
            Character alter = inboard[row+1][col];
            if(alter == 'X'){
                response = false;
            }
        }
        if (row > 0){
            Character alter = inboard[row-1][col];
            if(alter == 'X'){
                response = false;
            }
        }
        return response;
    }
    public char[][] makeNewGrid(String[] grid){
        char[][] newGrid = new char[4][4];
        for(int r= 0; r< 4; r++){
            for(int c = 0; c<4; c++){
                newGrid[r][c] = grid[r].charAt(c);
            }
        }
        return newGrid;
    }
    //THIS IS FROM LECTURE:
    private int winCount(char[][] board){
        int wins = 0;
        for(int r = 0; r < 4; r++){
            for(int c= 0; c< 4; c++){
                if (canMove(board,r,c)){
                    board[r][c] = 'X';
                    int opponentWins = winCount(board);
                    if (opponentWins == 0){
                        wins += 1;
                    }
                    board[r][c] = '.';
                }
            }
        }
        return wins;
    }

}
