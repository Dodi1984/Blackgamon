import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chip
{
	private int quadrant;
	private int pos_x;
	private int pos_y;
	private boolean selected = false;
	private boolean isSelectable = false;
		
	private BufferedImage bi;

	public Chip(int width, int height, int imageType, boolean isWhite)
	{
		this.bi = new BufferedImage(width, height, imageType);
		try
		{
			if (isWhite)
			{
				this.bi = ImageIO.read(getClass().getResourceAsStream("/pul2.png"));
			} else
			{
				this.bi = ImageIO.read(getClass().getResourceAsStream("/pul1.png"));
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public int getPos_x()
	{
		return pos_x;
	}

	public void setPos_x(int pos_x)
	{		 
		switch (this.quadrant)
		{
		case 1:			
			this.pos_x = Board.firstQuadrantPositions[pos_x][0];
			break;
		case 2:
			this.pos_x = Board.secondQuadrantPositions[pos_x][0];
			break;
		case 3:
			this.pos_x = Board.thirdQuadrantPositions[pos_x][0];
			break;
		case 4:			
			this.pos_x = Board.fourthQuadrantPositions[pos_x][0];
			break;
		}
	}

	public int getPos_y()
	{
		return this.pos_y;
	}

	public void setPos_y(int pos_y)
	{
		switch (this.quadrant)
		{
		case 1:			
			this.pos_y = Board.firstQuadrantPositions[0][pos_y];
			break;
		case 2:
			this.pos_y = Board.secondQuadrantPositions[0][pos_y];
			break;
		case 3:
			this.pos_y = Board.thirdQuadrantPositions[0][pos_y];
			break;
		case 4:
			this.pos_y = Board.fourthQuadrantPositions[0][pos_y];
			break;
		}
	}

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}

	public boolean isSelectable()
	{
		return isSelectable;
	}

	public void setSelectable(boolean isSelectable)
	{
		this.isSelectable = isSelectable;
	}

	public BufferedImage getBi()
	{
		return bi;
	}

	public void setBi(BufferedImage bi)
	{
		this.bi = bi;
	}

	
	public int getQuadrant()
	{
		return quadrant;
	}

	public void setQuadrant(int quadrant)
	{
		this.quadrant = quadrant;
	}

}
