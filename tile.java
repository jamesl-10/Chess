import javax.swing.*;

public class tile extends JButton
{
	// Change variables into preferably private
    private int xPosition;
    private int yPosition;
    
    // Constructor
    public tile(int xPosition, int yPosition)
    {
    	this.xPosition = xPosition;
    	this.yPosition = yPosition;
    }
    
    // Returns x position of spot
    public int getXPos()
    {
    	return xPosition;
    }
    
    // Returns y position of spot
    public int getYPos()
    {
    	return yPosition;
    }
    
    public static void checkTile(String s, int x, int y)
    {
        if(!s.equals(""))
        {
        	pieceMover.move(s, x, y);
        }
    }
}

