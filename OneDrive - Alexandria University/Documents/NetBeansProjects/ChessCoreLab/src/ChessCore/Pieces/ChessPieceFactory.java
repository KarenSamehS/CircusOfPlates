/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore.Pieces;

import ChessCore.PawnPromotion;
import ChessCore.Player;

/**
 *
 * @author karen
 */
public class ChessPieceFactory {
     

    public ChessPieceFactory() {
      
          }
    public Piece createPiece(String pieceType, Player owner) {
        switch (pieceType.toLowerCase()) {
            case "queen":
                return new Queen(owner);
            case "rook":
                return new Rook(owner);
            case "knight":
                return new Knight(owner);
            case "bishop":
                return new Bishop(owner);
            case "king":
                return new King(owner);
            case "pawn":
                    return new Pawn(owner);
            
        }
        return null;
    }

     
     public Piece createPiece(PawnPromotion promotion, Player owner) {
        switch (promotion) {
            case Queen:
                return new Queen(owner);
            case Rook:
                return new Rook(owner);
            case Knight:
                return new Knight(owner);
            case Bishop:
                return new Bishop(owner);
            default:
                throw new IllegalArgumentException("Invalid promotion type: " + promotion);
        }
    }
}
