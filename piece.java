import java.awt.Color;

class piece
{
	private final String pieceName;
	private final String color;
	
	public piece(String pieceName, String color)
	{
		this.pieceName = pieceName;
		this.color = color;
	}
	
	public String name()
	{
		return pieceName;
	}

	public String color()
	{
		return color;
	}
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		// TODO Auto-generated method stub
		
	}
	public void verifyMove(int x, int y, tile[][] board)
	{
		// TODO Auto-generated method stub
	}

	public void capture(int fromX, int fromY, int toX, int toY, tile[][] board)
	{
		// TODO Auto-generated method stub	
	}
}

class pawn extends piece
{
	boolean moved = false;
	
	public pawn(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		try
		{
			board[x-1][y].setText("\u25E6");
			
			if (moved == false)
			{
				board[x-2][y].setText("\u25E6");
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}
	
}

class knight extends piece
{
	public knight(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
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
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+2][y-1].getText().equals(""))
			{
				board[x+2][y-1].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+2][y+1].getText().equals(""))
			{
				board[x+2][y+1].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y-2].getText().equals(""))
			{
				board[x-1][y-2].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y+2].getText().equals(""))
			{
				board[x-1][y+2].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y+2].getText().equals(""))
			{
				board[x+1][y+2].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y-2].getText().equals(""))
			{
				board[x+1][y-2].setText("\u25E6");
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
	boolean moved = false;
	
	public bishop(String pieceName, String color)
	{
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				board[x-i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
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
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				board[x][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y].setText("\u25E6");
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
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
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				board[x-i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y].setText("\u25E6");
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
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
	public void verifyMove(int x, int y, tile[][] board)
	{
		try
		{
			board[x][y-1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x][y+1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x-1][y].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x-1][y-1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x-1][y+1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x+1][y].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x+1][y-1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x+1][y+1].setText("\u25E6");
		}
		catch(Exception e) {}
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
}
			
		}
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
		moved = true;
	}
	
}

class knight extends piece
{
	public knight(String pieceName)
	{
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	public void verifyMove(int x, int y, tile[][] board)
	{
		try
		{
			if (board[x-2][y-1].getText().equals(""))
			{
				board[x-2][y-1].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-2][y+1].getText().equals(""))
			{
				board[x-2][y+1].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+2][y-1].getText().equals(""))
			{
				board[x+2][y-1].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+2][y+1].getText().equals(""))
			{
				board[x+2][y+1].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y-2].getText().equals(""))
			{
				board[x-1][y-2].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x-1][y+2].getText().equals(""))
			{
				board[x-1][y+2].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y+2].getText().equals(""))
			{
				board[x+1][y+2].setText("\u25E6");
			}
		}
		catch(Exception e) {}
		
		try
		{
			if (board[x+1][y-2].getText().equals(""))
			{
				board[x+1][y-2].setText("\u25E6");
			}
		}
		catch(Exception e) {}	
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
}

class bishop extends piece
{
	boolean moved = false;
	
	public bishop(String pieceName)
	{
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				board[x-i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
}

class rook extends piece
{
	boolean moved = false;
	
	public rook(String pieceName)
	{
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				board[x][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y].setText("\u25E6");
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
}

class queen extends piece
{
	boolean moved = false;
	
	public queen(String pieceName)
	{
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyMove(int x, int y, tile[][] board)
	{
		for (int i = 1; i < 8; i++)
		{
			try
			{
				board[x-i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x][y-i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x][y+i].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x+i][y].setText("\u25E6");
			}
			catch(Exception e) {}
			
			try
			{
				board[x-i][y].setText("\u25E6");
			}
			catch(Exception e) {}
		}		
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
}

class king extends piece
{
	boolean moved = false;
	
	public king(String pieceName)
	{
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	public void verifyMove(int x, int y, tile[][] board)
	{
		try
		{
			board[x][y-1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x][y+1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x-1][y].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x-1][y-1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x-1][y+1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x+1][y].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x+1][y-1].setText("\u25E6");
		}
		catch(Exception e) {}
		
		try
		{
			board[x+1][y+1].setText("\u25E6");
		}
		catch(Exception e) {}
	}
	
	public void move(int fromX, int fromY, int x, int y, tile[][] board)
	{
		board[fromX][fromY].removePiece();
		board[x][y].addPiece(this);
	}
	
}
