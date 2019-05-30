import java.util.ArrayList;

public class player
{
	private static tile board[][];
	private final ArrayList<piece> playerPieces = new ArrayList<piece>();
	private final ArrayList<piece> capturedPieces = new ArrayList<piece>();
	private static piece currentPiece = null;
	private static int fromX = 0;
	private static int fromY = 0;
	
	public player(tile board[][])
	{
		this.board = board;
	}
	
	public void movePiece(String s, int x, int y)
	{
		if(s.equals("\u2654"))
		{
			board[x][y].setText("\u2654");
		}
	}
	
	public void playerPieces(piece p)
	{
		playerPieces.add(p);
	}
	
	public static void isValidMove(piece p, int x, int y)
	{
		p.verifyMove(x, y, board);
		fromX = x;
		fromY = y;
	}
	
	public static void setCurrentPiece(piece p)
	{
		currentPiece = p;
	}
    public static void movePiece(int toX, int toY)
    {
    	currentPiece.move(fromX, fromY, toX, toY, board);
    }
    
    public static void capturePiece(int toX, int toY)
    {
    	currentPiece.capture(fromX, fromY, toX, toY, board);
    }
}
