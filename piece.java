class piece
{
	private final String pieceName;
	
	public piece(String pieceName)
	{
		this.pieceName = pieceName;
	}
	
	public String name()
	{
		return pieceName;
	}
}

class pawn extends piece
{
	boolean moved = false;
	
	public pawn(String pieceName)
	{
		super(pieceName);
		// TODO Auto-generated constructor stub
	}
	public static void move(int x, int y)
	{
		board[x-1][y].setText("\u2654");
	}
	
}
