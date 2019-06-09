/****************************************************************************
 *
 * Created by: James Lee
 * Created on: Dec 2018
 * Created for: ICS4U
 * This is the player class
 * 
 * This class links the board, tiles, and pieces together, and allows the
 * pieces to be moved.
 *
 ****************************************************************************/

public class player
{
	private static tile board[][];
	private static piece currentPiece = null;
	private static int fromX = 0;
	private static int fromY = 0;
	
	public player(tile board[][])
	{
		this.board = board;
	}
	
	// Selects a piece
	// Very important in order to move piece
	public static void setCurrentPiece(piece p)
	{
		currentPiece = p;
	}
	
	// Verifies if move is legal
	public static void isValidMove(piece p, int x, int y)
	{
		p.verifyMove(x, y, board);
		fromX = x;
		fromY = y;
	}
	
	// Moves piece currently selected from function setCurrentPiece
    public static void movePiece(int toX, int toY)
    {
    	currentPiece.move(fromX, fromY, toX, toY, board);
    }
    
    // Captures with piece selected
    public static void capturePiece(int toX, int toY)
    {
    	currentPiece.capture(fromX, fromY, toX, toY, board);
    }
    
    // Castles
    public static void castleKing(int toX, int toY)
    {
    	currentPiece.castle(fromX, fromY, toX, toY, board);
    }
}
