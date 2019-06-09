/****************************************************************************
 *
 * Created by: James Lee
 * Created on: Dec 2018
 * Created for: ICS4U
 * This is the tile class
 * 
 * This class makes up the board
 *
 ****************************************************************************/

import javax.swing.*;

public class tile extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int xPosition;
    private int yPosition;
    private piece p;
    
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
    
    // Adds piece onto tile
    public void addPiece(piece p)
    {
    	this.p = p;
    	this.setText(p.name());
    }
    
    // Returns piece occupying tile
    public piece getPiece()
    {
    	return p;
    }
    
    // Removes piece occupying tile
    public void removePiece()
    {
    	this.p = null;
    	this.setText("");
    }
    
    // Checks if tile is empty
    public void checkTile(piece p, int x, int y)
    {
        if(!p.name().equals(""))
        {
        	player.isValidMove(p, x, y);
        }
    }
}
