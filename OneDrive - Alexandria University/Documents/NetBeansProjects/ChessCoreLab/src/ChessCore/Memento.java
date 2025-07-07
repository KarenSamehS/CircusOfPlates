/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author ADMIN
 */
public class Memento {
    private ChessBoard chessBoard = null;

    public Memento(ChessBoard b) {
       this.chessBoard=b;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }
    
    
}
