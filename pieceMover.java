public class pieceMover
{
	static tile board[][];
	
	public pieceMover(tile board[][])
	{
		this.board = board;
	}
	public static void move(String s, int x, int y)
	{
		if(s.equals("\u2654"))
		{
			board[x][y].setText("\u2654");
		}
	}
}

