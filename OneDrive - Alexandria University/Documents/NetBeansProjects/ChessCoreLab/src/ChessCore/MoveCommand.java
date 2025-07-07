/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author karen
 */
public class MoveCommand implements Command {
    private ChessGame game;
    private Square from;
    private Square to;
   private  PawnPromotion pP;
    public MoveCommand() {
    }
 
  public MoveCommand(ChessGame game, Square from, Square to, PawnPromotion pP) {
        this.game = game;
        this.from = from;
        this.to = to;
        this.pP = pP;
    }
    public MoveCommand(ChessGame game, Square from, Square to) {
        this.game = game;
        this.from = from;
        this.to = to;
        this.pP=pP.None;
    }
  
    @Override
    public boolean execute() {
        if(this.pP==pP.None)
        { 
            Move m = new Move(from,to);
               return  game.makeMove(m);
        }
    Move m2 = new Move(from,to,pP);
   return game.makeMove(m2);
    }
}

