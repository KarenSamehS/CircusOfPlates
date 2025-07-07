package ChessCore;

import ChessCore.Pieces.ChessPieceFactory;
import ChessCore.Pieces.Piece;

public final class ClassicBoardInitializer implements BoardInitializer {
    private static final BoardInitializer instance = new ClassicBoardInitializer();

    private ClassicBoardInitializer() {
    }

    public static BoardInitializer getInstance() {
        return instance;
    }

    @Override
    public Piece[][] initialize() {
         int boardSize = 8;
        Piece[][] initialState =new Piece[boardSize][boardSize]; 
        ChessPieceFactory pieceFactory = new ChessPieceFactory();
     for (int col = 0; col < boardSize; col++){
        for (int row = 0; row < 2; row++) {
           if(row==1)
            initialState[row][col] =  pieceFactory.createPiece("pawn",Player.WHITE);
           else
             initialState[row][col] = pieceFactory.createPiece(
                     (col == 0 || col == 7) ? "rook" :
            (col == 1 || col == 6) ? "knight" :
            (col == 2 || col == 5) ? "bishop" :
            (col == 3) ? "queen" : "king" ,
                     Player.WHITE );
        }
        for (int row=6;row<8;row++)
        {
            if(row==6)
                   initialState[row][col] = pieceFactory.createPiece("Pawn",Player.BLACK);
             else
             initialState[row][col] = pieceFactory.createPiece(
                     (col == 0 || col == 7) ? "Rook" :
            (col == 1 || col == 6) ? "Knight" :
            (col == 2 || col == 5) ? "Bishop" :
            (col == 3) ? "Queen" : "King" ,
                     Player.BLACK );
        }
    }   
         for (int row = 2; row < boardSize - 2; row++) {
            for (int col = 0; col < boardSize; col++) {
                initialState[row][col] = null;
            }
        }
    return initialState;
    }
}
