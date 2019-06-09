/****************************************************************************
 *
 * Created by: James Lee
 * Created on: Dec 2018
 * Created for: ICS4U
 * Chess program : plays chess with 2 players
 *
 *
 * Still needs : 
 * 
 * - Check and checkmate
 * - En passant
 * 
 ****************************************************************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class chess extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int turnNumber = 0;
	
	// Creates gui frame
	public static void main(String[] args) 
	{	
	    chess frame = new chess();
	    
	    frame.setTitle("Chess");
	    frame.setSize(1100, 1100);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);	    
	}

	// Chess board class constructor
	public chess() 
	{	
		// Creates a panel for the board
	    JPanel board = new JPanel();
	    
	    // Makes an 8 x 8 grid
	    board.setLayout(new GridLayout(8, 8));
	    board.setSize(1100, 1100);
	
		// Creates an array for the tiles
		tile[][] tiles = new tile[8][8];
		
		// Creates player
	    player player = new player(tiles);
		
		// Adds appropriate number of tiles for the chess board (64 total)
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				tile tile = new tile(i, j);
				tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 90));
				tiles[i][j] = tile;
				
				// Adds mouse event when pressed
				tiles[i][j].addMouseListener(new MouseListener()
				{					
				    @Override
				    public void mouseClicked(MouseEvent e)
				    {
				    	// TODO Auto-generated method stub 
				    }

					@Override
					public void mouseEntered(MouseEvent e)
					{
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseExited(MouseEvent e)
					{
						// TODO Auto-generated method stub
					}

					@Override
					public void mousePressed(MouseEvent e)
					{
						// TODO Auto-generated method stub
						
						// Captures enemy pieces
						if (tile.getBackground() == Color.RED)
						{
							player.capturePiece(tile.getXPos(), tile.getYPos());
							resetBoard(tiles);
							turnNumber++;
						}
						
						// Selects a piece to move
						// Also implements turns (whites turn, blacks turn)
						else if (tile.getPiece() != null && turnNumber%2 == 0 && 
							((tile) e.getSource()).getPiece().color().equals("White") || 
							tile.getPiece() != null &&
							turnNumber%2 == 1 && ((tile) e.getSource()).getPiece().color().equals("Black"))
						{
							resetBoard(tiles);
							tile.checkTile(((tile) e.getSource()).getPiece(), tile.getXPos(), tile.getYPos());
							player.setCurrentPiece(((tile) e.getSource()).getPiece());
						}
						
						// Moves piece that was selected above
						else if (tile.getText().equals("\u25E6"))
						{
							player.movePiece(tile.getXPos(), tile.getYPos());
							resetBoard(tiles);
							turnNumber++;
						}
						
						// Castles
						else if (tile.getText().equals("\u21c6"))
						{
							player.castleKing(tile.getXPos(), tile.getYPos());
							resetBoard(tiles);
							turnNumber++;
						}
						
						else
						{
							resetBoard(tiles);
						}
					}		

					@Override
					public void mouseReleased(MouseEvent e)
					{
						// TODO Auto-generated method stub
						
					}

				});
				
				// Creates the board
				board.add(tiles[i][j]);
			}
		}
		
		// This function resets the board to its original state
		// Colors are reset, and all text is removed
		// Note that pieces are exempt from this
		resetBoard(tiles);
		
	    /*
	    "\u2654 " + // white king
        "\u2655 " + // white queen
        "\u2656 " + // white rook
        "\u2657 " + // white bishop
        "\u2658 " + // white knight
        "\u2659 " + // white pawn
        "\n" +
        "\u265A " + // black king
        "\u265B " + // black queen
        "\u265C " + // black rook
        "\u265D " + // black bishop
        "\u265E " + // black knight
        "\u265F " + // black pawn
        
        */
	    
		// White's pieces
		
		// White pawns
		piece wp1 = new pawn("\u2659", "White");
	    piece wp2 = new pawn("\u2659", "White");
	    piece wp3 = new pawn("\u2659", "White");
	    piece wp4 = new pawn("\u2659", "White");
	    piece wp5 = new pawn("\u2659", "White");
	    piece wp6 = new pawn("\u2659", "White");
	    piece wp7 = new pawn("\u2659", "White");
	    piece wp8 = new pawn("\u2659", "White");
	    
	    // White king
	    piece wk = new king("\u2654", "White");
	    
	    // White queen
	    piece wq = new queen("\u2655", "White");
	    
	    // White knights
	    piece wn1 = new knight("\u2658", "White");
	    piece wn2 = new knight("\u2658", "White");
	    
	    // White bishops
	    piece wb1 = new bishop("\u2657", "White");
	    piece wb2 = new bishop("\u2657", "White");
	    
	    // White rooks
	    piece wr1 = new rook("\u2656", "White");
	    piece wr2 = new rook("\u2656", "White");
	    
	    // Black pieces
	    
	    // Black pawns
		piece bp1 = new pawn("\u265F", "Black");
	    piece bp2 = new pawn("\u265F", "Black");
	    piece bp3 = new pawn("\u265F", "Black");
	    piece bp4 = new pawn("\u265F", "Black");
	    piece bp5 = new pawn("\u265F", "Black");
	    piece bp6 = new pawn("\u265F", "Black");
	    piece bp7 = new pawn("\u265F", "Black");
	    piece bp8 = new pawn("\u265F", "Black");
	    
	    // Black king
	    piece bk = new king("\u265A", "Black");
	    
	    // Black queen
	    piece bq = new queen("\u265B", "Black");
	    
	    // Black knights
	    piece bn1 = new knight("\u265E", "Black");
	    piece bn2 = new knight("\u265E", "Black");
	    
	    // Black bishops
	    piece bb1 = new bishop("\u265D", "Black");
	    piece bb2 = new bishop("\u265D", "Black");
	    
	    // Black rooks
	    piece br1 = new rook("\u265C", "Black");
	    piece br2 = new rook("\u265C", "Black");

	    
	    // Map of all the coordinates on the board
	    
	    // tiles[letter][number]
	    /*
	     *       a file     b file      c file      d file       e file     f file      g file      h file
	     *     -----------------------------------------------------------------------------------------------
	     *     7,0 -> a1 | 7,1 -> b1 | 7,2 -> c1 | 7,3 -> d1 | 7,4 -> e1 | 7,5 -> f1 | 7,6 -> g1 | 7,7 -> h1
	     *     6,0 -> a2 | 6,1 -> b2 | 6,2 -> c2 | 6,3 -> d2 | 6,4 -> e2 | 6,5 -> f2 | 6,6 -> g2 | 6,7 -> h2
	     *     5,0 -> a3 | 5,1 -> b3 | 5,2 -> c3 | 5,3 -> d3 | 5,4 -> e3 | 5,5 -> f3 | 5,6 -> g3 | 5,7 -> h3
	     *     4,0 -> a4 | 4,1 -> b4 | 4,2 -> c4 | 4,3 -> d4 | 4,4 -> e4 | 4,5 -> f4 | 4,6 -> g4 | 4,7 -> h4
	     *     3,0 -> a5 | 3,1 -> b5 | 3,2 -> c5 | 3,3 -> d5 | 3,4 -> e5 | 3,5 -> f5 | 3,6 -> g5 | 3,7 -> h5
	     *     2,0 -> a6 | 2,1 -> b6 | 2,2 -> c6 | 2,3 -> d6 | 2,4 -> e6 | 2,5 -> f6 | 2,6 -> g6 | 2,7 -> h6
	     *     1,0 -> a7 | 1,1 -> b7 | 1,2 -> c7 | 1,3 -> d7 | 1,4 -> e7 | 1,5 -> f7 | 1,6 -> g7 | 1,7 -> h7
	     *     0,0 -> a8 | 0,1 -> b8 | 0,2 -> c8 | 0,3 -> d8 | 0,4 -> e8 | 0,5 -> f8 | 0,6 -> g8 | 0,7 -> h8
	     * 
	     */
	    
	    // Places white pieces in position
	    tiles[6][0].addPiece(wp1);
	    tiles[6][1].addPiece(wp2);
	    tiles[6][2].addPiece(wp3);
	    tiles[6][3].addPiece(wp4);
	    tiles[6][4].addPiece(wp5);
	    tiles[6][5].addPiece(wp6);
	    tiles[6][6].addPiece(wp7);
	    tiles[6][7].addPiece(wp8);
	    tiles[7][0].addPiece(wr1);
	    tiles[7][1].addPiece(wn1);
	    tiles[7][2].addPiece(wb1);
	    tiles[7][3].addPiece(wq);
	    tiles[7][4].addPiece(wk);
	    tiles[7][5].addPiece(wb2);	    
	    tiles[7][6].addPiece(wn2);
	    tiles[7][7].addPiece(wr2);
	    
	    // Places black pieces in position
	    tiles[1][0].addPiece(bp1);
	    tiles[1][1].addPiece(bp2);
	    tiles[1][2].addPiece(bp3);
	    tiles[1][3].addPiece(bp4);
	    tiles[1][4].addPiece(bp5);
	    tiles[1][5].addPiece(bp6);
	    tiles[1][6].addPiece(bp7);
	    tiles[1][7].addPiece(bp8);
	    tiles[0][0].addPiece(br1);
	    tiles[0][1].addPiece(bn1);
	    tiles[0][2].addPiece(bb1);
	    tiles[0][3].addPiece(bq);
	    tiles[0][4].addPiece(bk);
	    tiles[0][5].addPiece(bb2);
	    tiles[0][6].addPiece(bn2);
	    tiles[0][7].addPiece(br2);
	
	    // Creates board
	    add(board);
	    
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	// Function that restores board to original state
	// Note that pieces are exempt from this
	public void resetBoard(tile[][] tiles)
	{
		// Colors of board
		Color BROWN = new Color(222,184,135);
		Color WHITE = new Color(255,248,250);
		
		for (int i = 0; i < tiles[0].length; i++)
		{
			for (int j = 0; j < tiles.length; j++)
			{
				if (tiles[i][j].getText().equals("\u25E6") || tiles[i][j].getText().equals("\u21c6"))
				{
					tiles[i][j].setText("");
				}
				
				if (i % 2 == 0)
				{
					if(j % 2 == 0)
					{
					    tiles[i][j].setBackground(BROWN);
					}
					else
					{
					    tiles[i][j].setBackground(WHITE);
					}

				}
				else
				{
					if (j % 2 == 0)
					{
						tiles[i][j].setBackground(WHITE);
					}
					else
					{
						tiles[i][j].setBackground(BROWN);
					}
				}
			}
		}
	}
}
