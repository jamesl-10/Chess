/****************************************************************************
 *
 * Created by: James Lee
 * Created on: Dec 2018
 * Created for: ICS4U
 * This is the piece class
 * 
 * Pieces include : 
 * 
 * - Pawn
 * - Knight
 * - Bishop
 * - Rook
 * - Queen
 * - King
 *
 ****************************************************************************/

import java.awt.Color;

class piece
{
	// Properties
	private final String pieceName;
	private final String color;
	private boolean moved;
	
	// Constructor
	public piece(String pieceName, String color)
	{
		this.pieceName = pieceName;
		this.color = color;
	}
	
	// Returns name
	public String name()
	{
		return pieceName;
	}

	// Returns color
	public String color()
	{
		return color;
	}
	
	// Moves piece
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		// TODO Auto-generated method stub
		
	}
	
	// Verifies if move is possible
	public void verifyMove(int x, int y, tile[][] board)
	{
		// TODO Auto-generated method stub
	}

	// Captures piece
	public void capture(int fromX, int fromY, int toX, int toY, tile[][] board)
	{
		// TODO Auto-generated method stub	
	}
	
	// Specific to king; castles
	public void castle(int fromX, int fromY, int toX, int toY, tile[][] board)
	{
		
	}
	
	// Returns whether piece was moved or not
	public boolean wasMoved()
	{
		return moved;
	}
}

// Pawn class
class pawn extends piece
{
	boolean moved = false;
	
	public pawn(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	// Pawn can move in these patterns :
	// - Can move one space directly up
	// - MUST capture diagonally one space
	// - Can move two squares on first move
	public void verifyMove(int x, int y, tile[][] board)
	{
		// White pawns
		// Moves up one square
		if (this.color().equals("White"))
		{
			try
			{
				if (board[x-1][y].getText().equals(""))
				{
					board[x-1][y].setText("\u25E6");
					
					// Moves up two squares
					if (moved == false)
					{
						if (board[x-2][y].getText().equals(""))
						{
							board[x-2][y].setText("\u25E6");
						}
					}
				}
			}
			catch(Exception e) {}
			
			// Captures diagonally to the right
			try
			{
				if (!board[x-1][y+1].getPiece().color().equals(this.color()))
				{
					board[x-1][y+1].setBackground(Color.RED);
				}
			}
			catch (Exception e) {}
			
			// Captures diagonally to the right
			try
			{
				if (!board[x-1][y-1].getPiece().color().equals(this.color()))
				{
					board[x-1][y-1].setBackground(Color.RED);
				}
			}
			catch (Exception e) {}
		}
		
		// Black pawns
		else
		{
			// Moves up one square
			try
			{
				if (board[x+1][y].getText().equals(""))
				{
					board[x+1][y].setText("\u25E6");
					
					// Moves up two squares
					if (moved == false)
					{
						if (board[x+2][y].getText().equals(""))
						{
							board[x+2][y].setText("\u25E6");
						}
					}
				}
			}
			catch(Exception e) {}
			
			// Captures diagonally to the right
			try
			{
				if (!board[x+1][y+1].getPiece().color().equals(this.color()))
				{
					board[x+1][y+1].setBackground(Color.RED);
				}
			}
			catch (Exception e) {}
			
			// Captures diagonally to the left
			try
			{
				if (!board[x+1][y-1].getPiece().color().equals(this.color()))
				{
					board[x+1][y-1].setBackground(Color.RED);
				}
			}
			catch (Exception e) {}
		}
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
		moved = true;
		
		// Make black queen if black pawn
		
		if (x == 0)
		{
			board[x][y].removePiece();
			
			piece promotedQueen = new queen("\u2655", this.color());
			board[x][y].addPiece(promotedQueen);
		}
		
		if (x == 7)
		{
			board[x][y].removePiece();
			piece promotedQueen = new queen("\u265B", this.color());
			board[x][y].addPiece(promotedQueen);
		}
	}
	
	public void capture(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].removePiece();
		board[x][y].addPiece(this);
		
		if (x == 0)
		{
			board[x][y].removePiece();
			
			piece promotedQueen = new queen("\u2655", this.color());
			board[x][y].addPiece(promotedQueen);
		}
		if (x == 7)
		{
			board[x][y].removePiece();
			piece promotedQueen = new queen("\u265B", this.color());
			board[x][y].addPiece(promotedQueen);
		}
	}
}

class knight extends piece
{
	public knight(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	// Knight can move in these patterns :
	// - Two squares any direction, then one square (in an L shape)
	
	public void verifyMove(int x, int y, tile[][] board)
	{

		try
		{
			if (board[x-2][y-1].getText().equals(""))
			{
				board[x-2][y-1].setText("\u25E6");
			}
			else if(!board[x-2][y-1].getPiece().color().equals(this.color()))
			{
				board[x-2][y-1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-2][y+1].getText().equals(""))
			{
				board[x-2][y+1].setText("\u25E6");
			}
			else if(!board[x-2][y+1].getPiece().color().equals(this.color()))
			{
				board[x-2][y+1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+2][y-1].getText().equals(""))
			{
				board[x+2][y-1].setText("\u25E6");
			}
			else if(!board[x+2][y-1].getPiece().color().equals(this.color()))
			{
				board[x+2][y-1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+2][y+1].getText().equals(""))
			{
				board[x+2][y+1].setText("\u25E6");
			}
			else if(!board[x+2][y+1].getPiece().color().equals(this.color()))
			{
				board[x+2][y+1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y-2].getText().equals(""))
			{
				board[x-1][y-2].setText("\u25E6");
			}
			else if(!board[x-1][y-2].getPiece().color().equals(this.color()))
			{
				board[x-1][y-2].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y+2].getText().equals(""))
			{
				board[x-1][y+2].setText("\u25E6");
			}
			else if(!board[x-1][y+2].getPiece().color().equals(this.color()))
			{
				board[x-1][y+2].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y+2].getText().equals(""))
			{
				board[x+1][y+2].setText("\u25E6");
			}
			else if(!board[x+1][y+2].getPiece().color().equals(this.color()))
			{
				board[x+1][y+2].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y-2].getText().equals(""))
			{
				board[x+1][y-2].setText("\u25E6");
			}
			else if(!board[x+1][y-2].getPiece().color().equals(this.color()))
			{
				board[x+1][y-2].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}	
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
	public void capture(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].removePiece();
		board[x][y].addPiece(this);
	}
	
}

class bishop extends piece
{	
	public bishop(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	// Bishop can move in these patterns :
	// - Any number of squares diagonally
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x-i][y-i].getText().equals(""))
				{
					board[x-i][y-i].setText("\u25E6");
				}
				else if (!board[x-i][y-i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x-i][y-i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x-i][y+i].getText().equals(""))
				{
					board[x-i][y+i].setText("\u25E6");
				}
				else if (!board[x-i][y+i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x-i][y+i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}		
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x+i][y-i].getText().equals(""))
				{
					board[x+i][y-i].setText("\u25E6");
				}
				else if (!board[x+i][y-i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x+i][y-i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x+i][y+i].getText().equals(""))
				{
					board[x+i][y+i].setText("\u25E6");
				}
				else if (!board[x+i][y+i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x+i][y+i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
	public void capture(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].removePiece();
		board[x][y].addPiece(this);
	}
	
}

class rook extends piece
{
	boolean moved = false;
	
	public rook(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	public boolean wasMoved()
	{
		return moved;
	}
	
	// Rook can move in these patterns :
	// - Any number of squares horizontally/vertically
	
	public void verifyMove(int x, int y, tile[][] board)
	{	
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x][y-i].getText().equals(""))
				{
					board[x][y-i].setText("\u25E6");
				}
				else if (!board[x][y-i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x][y-i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x][y+i].getText().equals(""))
				{
					board[x][y+i].setText("\u25E6");
				}
				else if (!board[x][y+i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x][y+i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
			
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x+i][y].getText().equals(""))
				{
					board[x+i][y].setText("\u25E6");
				}
				else if (!board[x+i][y].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x+i][y].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
			
		}
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x-i][y].getText().equals(""))
				{
					board[x-i][y].setText("\u25E6");
				}
				else if (!board[x-i][y].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x-i][y].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}
	
	public void capture(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}
	
}

class queen extends piece
{
	boolean moved = false;
	
	public queen(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	// Queen can move in these patterns :
	// - Any number of squares diagonally
	// - Any number of squares vertically/horizontally
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x-i][y-i].getText().equals(""))
				{
					board[x-i][y-i].setText("\u25E6");
				}
				else if (!board[x-i][y-i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x-i][y-i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x-i][y+i].getText().equals(""))
				{
					board[x-i][y+i].setText("\u25E6");
				}
				else if (!board[x-i][y+i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x-i][y+i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}		
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x+i][y-i].getText().equals(""))
				{
					board[x+i][y-i].setText("\u25E6");
				}
				else if (!board[x+i][y-i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x+i][y-i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x+i][y+i].getText().equals(""))
				{
					board[x+i][y+i].setText("\u25E6");
				}
				else if (!board[x+i][y+i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x+i][y+i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
			}
			catch(Exception e) {}
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x][y-i].getText().equals(""))
				{
					board[x][y-i].setText("\u25E6");
				}
				else if (!board[x][y-i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x][y-i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x][y+i].getText().equals(""))
				{
					board[x][y+i].setText("\u25E6");
				}
				else if (!board[x][y+i].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x][y+i].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
			
		}
		
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x+i][y].getText().equals(""))
				{
					board[x+i][y].setText("\u25E6");
				}
				else if (!board[x+i][y].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x+i][y].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
		}
		for (int i = 1; i < 8; i++)
		{
			try
			{
				if (board[x-i][y].getText().equals(""))
				{
					board[x-i][y].setText("\u25E6");
				}
				else if (!board[x-i][y].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
				{
					board[x-i][y].setBackground(Color.RED);
					break;
				}
				else
				{
					break;
				}
				
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}
	
	public void capture(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}
	
}

class king extends piece
{
	boolean moved = false;
	
	public king(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	// King can move in these patterns :
	// - Any space 1 square away
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		try
		{
			if (board[x][y-1].getText().equals(""))
			{
				board[x][y-1].setText("\u25E6");
			}
			else if (!board[x][y-1].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x][y-1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x][y+1].getText().equals(""))
			{
				board[x][y+1].setText("\u25E6");
			}
			else if (!board[x][y+1].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x][y+1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y].getText().equals(""))
			{
				board[x-1][y].setText("\u25E6");
			}
			else if (!board[x-1][y].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x-1][y].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y-1].getText().equals(""))
			{
				board[x-1][y-1].setText("\u25E6");
			}
			else if (!board[x-1][y-1].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x-1][y-1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y+1].getText().equals(""))
			{
				board[x-1][y+1].setText("\u25E6");
			}
			else if (!board[x-1][y+1].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x-1][y+1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y].getText().equals(""))
			{
				board[x+1][y].setText("\u25E6");
			}
			else if (!board[x+1][y].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x+1][y].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y-1].getText().equals(""))
			{
				board[x+1][y-1].setText("\u25E6");
			}
			else if (!board[x+1][y-1].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x+1][y-1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y+1].getText().equals(""))
			{
				board[x+1][y+1].setText("\u25E6");
			}
			else if (!board[x+1][y+1].getPiece().color().equals(this.color()) && board[x][y].getBackground() != Color.RED)
			{
				board[x+1][y+1].setBackground(Color.RED);
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (this.moved == false)
			{
				if (board[x][y+3].getPiece().wasMoved() == false)
				{
					if (board[x][y+1].getPiece() == null && board[x][y+2].getPiece() == null)
					{
						board[x][y+2].setText("\u21c6");
					}
				}
				
				if (board[x][y-4].getPiece().wasMoved() == false)
				{					
					if (board[x][y-3].getPiece() == null && board[x][y-2].getPiece() == null && board[x][y-1].getPiece() == null)
					{
						board[x][y-2].setText("\u21c6");
					}
				}
			}
		}
		catch (Exception e) {}
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}
	
	public void capture(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}

	// Castles with rook
	public void castle(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);

		if (y == 6)
		{
			board[x][y-1].addPiece(board[x][y+1].getPiece());
			board[x][y+1].removePiece();
		}
		else if (y == 2)
		{
			board[x][y+1].addPiece(board[x][y-2].getPiece());
			board[x][y-2].removePiece();
		}

		moved = true;
	}
}
