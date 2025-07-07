/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import ChessCore.BoardFile;
import ChessCore.BoardRank;
import ChessCore.ClassicChessGame;
import ChessCore.Command;
import ChessCore.GameStatus;
import ChessCore.MoveCommand;
import ChessCore.PawnPromotion;
import ChessCore.Pieces.Bishop;
import ChessCore.Pieces.King;
import ChessCore.Pieces.Knight;
import ChessCore.Pieces.Pawn;
import ChessCore.Pieces.Piece;
import ChessCore.Pieces.Queen;
import ChessCore.Pieces.Rook;
import ChessCore.Player;
import ChessCore.Square;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */

public class ChessBoard extends JPanel implements MouseListener {
   
   boolean gameEnded=false;
    ArrayList<Square> validMoves = null;
    Square sourceSquare = null;
    Square destinationSquare = null;
    PawnPromotion pp=null;
    
    Command moveCommand=null;

    public ChessBoard() {
        addMouseListener(this);
   
    }

    ClassicChessGame cg = new ClassicChessGame();
    boolean firstPress = false;
    static Image[] img;

    public static void main(String args[]) throws IOException {
        JFrame cb = new JFrame();
        cb.getContentPane().setBackground(new Color(240, 217, 181)); 
   
        BufferedImage all = ImageIO.read(new File("C:\\chess.png"));
        img = loadChessPieceImages(all);
        cb.setLayout(null);
        cb.setSize(750, 750);
        ChessBoard b= new ChessBoard();
        b.setBounds(0,0,650,650);
        
        cb.getContentPane().add(b);
        JButton undoButton =new JButton("Undo");//+
        undoButton.setPreferredSize(new Dimension(30,30));//+
        undoButton.setBackground(new Color(181, 136, 99));
         undoButton.setBounds(620,60,100,30);
        cb.getContentPane().add(undoButton); 
      
       undoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      if (!b.gameEnded) {
                
                    b.cg.undo();
                    b.repaint();
                    b.firstPress=false;
                    JOptionPane.showOptionDialog(null, "Move undone", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                
                } else {
                    JOptionPane.showOptionDialog(null, "Game already ended", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                }
            
       }
       });
         

        cb.setLocationRelativeTo(null);
        cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cb.setTitle("Chess Game");
        cb.setVisible(true);
       
    }
    //boardsize 8 squaresize 75
    //boardheight=boardwidth = board size * square size
   

    @Override
    public void paint(Graphics gp) {
        setBackground(new Color(240, 217, 181));
        super.paintComponent(gp);
        for (int r = 0; r < 8; r++) {//r row
            for (int c = 0; c < 8; c++) { //c column 
                int x = c * 75;
                int y = r * 75;
                if ((r + c) % 2 == 0) {
                    gp.setColor(new Color(240, 217, 181));
                } else {
                    gp.setColor(new Color(181, 136, 99));
                }
                gp.fillRect(x, y, 75, 75);
                Square s = null;
                if (cg.getWhoseTurn() == Player.WHITE) {
                    // flipped
                    s = new Square(BoardFile.values()[c], BoardRank.values()[7-r]);

                } else {
                    // normal board
                    s = new Square(BoardFile.values()[c], BoardRank.values()[r]);

                }
                Piece p = cg.getPieceAtSquare(s);
                if (p instanceof King) {
                    if (p.getOwner() == Player.BLACK) {
                        if (cg.getGameStatus() == GameStatus.BLACK_UNDER_CHECK) {
                          
                            gp.setColor(Color.red);
                            gp.fillRect(x, y, 75, 75);
                           
                        }
                        gp.drawImage(img[6], x, y, this);

                    } else {
                         if (cg.getGameStatus() == GameStatus.WHITE_UNDER_CHECK) {
                            
                            gp.setColor(Color.red);
                            gp.fillRect(x, y, 75, 75);
                            
                         }
                        gp.drawImage(img[0], x, y, this);
                          
                            
                    }
                } else if (p instanceof Queen) {
                    if (p.getOwner() == Player.BLACK) {
                        gp.drawImage(img[7], x, y, this);
                    } else {
                        gp.drawImage(img[1], x, y, this);
                    }
                } else if (p instanceof Bishop) {
                    if (p.getOwner() == Player.BLACK) {
                        gp.drawImage(img[8], x, y, this);
                    } else {
                        gp.drawImage(img[2], x, y, this);
                    }
                } else if (p instanceof Knight) {
                    if (p.getOwner() == Player.BLACK) {
                        gp.drawImage(img[9], x, y, this);
                    } else {
                        gp.drawImage(img[3], x, y, this);
                    }
                } else if (p instanceof Rook) {
                    if (p.getOwner() == Player.BLACK) {
                        gp.drawImage(img[10], x, y, this);
                    } else {
                        gp.drawImage(img[4], x, y, this);
                    }
                } else if (p instanceof Pawn) {
                    if (p.getOwner() == Player.BLACK) {
                        gp.drawImage(img[11], x, y, this);
                    } else {
                        gp.drawImage(img[5], x, y, this);
                    }
                }
            }
        Color highlight = new Color(0, 255, 0, 100); // 64 is the alpha value for more transparency
if (sourceSquare != null) {
    validMoves = (ArrayList<Square>) cg.getAllValidMovesFromSquare(sourceSquare);
    Graphics2D g2d = (Graphics2D) gp; // Cast Graphics to Graphics2D
    for (int i = 0; i < validMoves.size(); i++) {
        Square s = validMoves.get(i);
        if (s != null) {
            int f = s.getFile().getValue();
            int k = 0;
            if (cg.getWhoseTurn() == Player.WHITE)
                k = 7 - s.getRank().getValue();
            else
                k = s.getRank().getValue();

            g2d.setColor(highlight);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f)); 
            int squareSize = 75;
            int circleDiameter = (int) (squareSize * 0.8); 
            int circleX = f * squareSize + (squareSize - circleDiameter) / 2;
            int circleY = k * squareSize + (squareSize - circleDiameter) / 2;
            g2d.fillOval(circleX, circleY, circleDiameter, circleDiameter);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f)); // Reset to fully opaque
        }
    }
}
        }
    }

    private static Image[] loadChessPieceImages(BufferedImage all) {
        Image[] imgs = new Image[12];
        int ind = 0;
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
        return imgs;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

 @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / 75;
        int row = e.getY() / 75;
        if(row>7||col>7){ //for button frame problem
            return;
        }
        if (firstPress == false) {
            if (cg.getWhoseTurn() == Player.WHITE) {
                sourceSquare = new Square(BoardFile.values()[col], BoardRank.values()[7-row]);
            } else {
                sourceSquare = new Square(BoardFile.values()[col], BoardRank.values()[row]);
            }

            firstPress = true;
            repaint();
        } else {
            if (cg.getWhoseTurn() == Player.WHITE) {

                destinationSquare = new Square(BoardFile.values()[col], BoardRank.values()[7-row]);
            } else {
                destinationSquare = new Square(BoardFile.values()[col], BoardRank.values()[row]);

            }
            Piece sourcePiece = cg.getPieceAtSquare(sourceSquare);
             Piece destinationPiece = cg.getPieceAtSquare(destinationSquare);
              if(((destinationSquare.getRank()==BoardRank.EIGHTH &&sourcePiece.getOwner()==Player.WHITE)  || ((destinationSquare.getRank()==BoardRank.FIRST)&&sourcePiece.getOwner()==Player.BLACK)) && (cg.getPieceAtSquare(sourceSquare) instanceof Pawn  ) )
                {
                   if ( destinationPiece==null ||sourcePiece.getOwner() != destinationPiece.getOwner()) {
                    String[] piecesOptions = { "QUEEN", "KNIGHT", "BISHOP","ROOK" };
                    int answer=JOptionPane.showOptionDialog(this,"Select Promotion Piece:","",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,piecesOptions,piecesOptions[1]);
                switch (answer) {
                    case 0:
                        pp=PawnPromotion.valueOf("Queen");
                        break;
                    case 1:
                        pp=PawnPromotion.valueOf("Knight");
                        break;
                    case 2:
                        pp=PawnPromotion.valueOf("Bishop");
                        break;
                    case 3:
                        pp=PawnPromotion.valueOf("Rook");
                        break;
                    default:
                        pp=PawnPromotion.valueOf("None");
                        break;
              }
                 
                moveCommand = new MoveCommand(cg,sourceSquare,destinationSquare,pp);
           
            } 
                }
          else{
               
                    moveCommand = new MoveCommand(cg,sourceSquare,destinationSquare);
              }
            if (moveCommand.execute()) {
              
              
            } 
       
        else {
                if ((cg.getGameStatus() == GameStatus.BLACK_WON||cg.getGameStatus() == GameStatus.WHITE_WON||cg.getGameStatus() == GameStatus.STALEMATE||cg.getGameStatus() == GameStatus.INSUFFICIENT_MATERIAL)) {
                 JOptionPane.showOptionDialog(null, "Game already ended","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                gameEnded=true;
                 return;
            }else{
                JOptionPane.showOptionDialog(null, "Invalid Move","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
            }
             if (cg.getGameStatus() == GameStatus.BLACK_WON) {
                 JOptionPane.showOptionDialog(null, "Black Won","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
            if (cg.getGameStatus() == GameStatus.WHITE_WON) {
                  JOptionPane.showOptionDialog(null, "White won","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
            if (cg.getGameStatus() == GameStatus.STALEMATE) {
                  JOptionPane.showOptionDialog(null, "Stalemate","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
            if (cg.getGameStatus() == GameStatus.INSUFFICIENT_MATERIAL) {
                   JOptionPane.showOptionDialog(null, "Insufficient Material","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
            if (cg.getGameStatus() == GameStatus.WHITE_UNDER_CHECK) {
                   JOptionPane.showOptionDialog(null, "White in check","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
            if (cg.getGameStatus() == GameStatus.BLACK_UNDER_CHECK) {
                   JOptionPane.showOptionDialog(null, "Black in check","", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            }
            firstPress = false;
            sourceSquare = null;
            repaint();

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}
                
   

