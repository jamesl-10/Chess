import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

// Make all panels the same array, instead of two separate for each color
public class chess extends JFrame implements ActionListener
{
	public static void main(String[] args) 
	{
	
	    chess frame = new chess();
	    
	    frame.setTitle("Chess");
	    frame.setSize(900, 900);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	}

	// Chess board class constructor
	public chess() 
	{
		
		// Creates a panel for the board
	    board board = new board();
	    
	    // Makes an 8 x 8 grid
	    board.setLayout(new GridLayout(8, 8));
	    board.setSize(800, 800);
	
		// Creates an array for the tiles
		tile[][] tiles = new tile[8][8];
		
		// Creates chess board, with proper colors
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				tile tile = new tile(i, j);
				
				// Decides the color of tile
				if (i % 2 == 0)
				{
					if(j % 2 == 0)
					{
					    tile.setBackground(Color.GREEN);
					}
					else
					{
					    tile.setBackground(Color.WHITE);
					}

				}
				else
				{
					if (j % 2 == 0)
					{
						tile.setBackground(Color.WHITE);
					}
					else
					{
						tile.setBackground(Color.GREEN);
					}
				}
				tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
				
				tiles[i][j] = tile;
				
				tiles[i][j].addMouseListener(new MouseListener() {
				    @Override
				    public void mouseClicked(MouseEvent e)
				    {
				    	int x = tile.getXPos();
				        int y = tile.getYPos();
				        tile.checkTile(((tile) e.getSource()).getPiece(), tile.getXPos(), tile.getYPos());
				    }

					@Override
					public void mouseEntered(MouseEvent e)
					{
						// TODO Auto-generated method stub
//						tile.getText() = 
						
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
						
					}

					@Override
					public void mouseReleased(MouseEvent e)
					{
						// TODO Auto-generated method stub
						
					}

				});
				
				board.add(tiles[i][j]);
			}
		}
		
	    
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
		piece wp1 = new pawn("\u2659");
	    piece wp2 = new pawn("\u2659");
	    piece wp3 = new pawn("\u2659");
	    piece wp4 = new pawn("\u2659");
	    piece wp5 = new pawn("\u2659");
	    piece wp6 = new pawn("\u2659");
	    piece wp7 = new pawn("\u2659");
	    piece wp8 = new pawn("\u2659");
	    
	    // White king
	    piece wk = new piece("\u2654");
	    
	    // White queen
	    piece wq = new piece("\u2655");
	    
	    // White knights
	    piece wn1 = new piece("\u2658");
	    piece wn2 = new piece("\u2657");
	    
	    // White bishops
	    piece wb1 = new piece("\u2657");
	    piece wb2 = new piece("\u2658");
	    
	    // White rooks
	    piece wr1 = new piece("\u2656");
	    piece wr2 = new piece("\u2656");
	    
	    // Black pieces
	    // Black pawns
		piece bp1 = new pawn("\u265F");
	    piece bp2 = new pawn("\u265F");
	    piece bp3 = new pawn("\u265F");
	    piece bp4 = new pawn("\u265F");
	    piece bp5 = new pawn("\u265F");
	    piece bp6 = new pawn("\u265F");
	    piece bp7 = new pawn("\u265F");
	    piece bp8 = new pawn("\u265F");
	    
	    // Black king
	    piece bk = new piece("\u265A");
	    
	    // Black queen
	    piece bq = new piece("\u265B");
	    
	    // Black knights
	    piece bn1 = new piece("\u265E");
	    piece bn2 = new piece("\u265E");
	    
	    // Black bishops
	    piece bb1 = new piece("\u265D");
	    piece bb2 = new piece("\u265D");
	    
	    // Black rooks
	    piece br1 = new piece("\u265C");
	    piece br2 = new piece("\u265C");

	    
	    
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
	    tiles[7][5].addPiece(wn2);
	    tiles[7][6].addPiece(wb2);
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
	    pieceMover mover = new pieceMover(tiles);
	    
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
