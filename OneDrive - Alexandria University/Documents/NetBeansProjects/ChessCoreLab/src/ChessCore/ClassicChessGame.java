package ChessCore;

import ChessCore.Pieces.ChessPieceFactory;

public final class ClassicChessGame extends ChessGame {

    public ClassicChessGame() {
        super(ClassicBoardInitializer.getInstance(),new ChessPieceFactory());
    }

    @Override
    protected boolean isValidMoveCore(Move move) {
        return !Utilities.willOwnKingBeAttacked(this.getWhoseTurn(), move, this.getBoard());
    }
    
}
