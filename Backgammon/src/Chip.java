import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chip
{
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
		this.pos_x = pos_x;
	}

	public int getPos_y()
	{
		return this.pos_y;
	}

	public void setPos_y(int pos_y)
	{
		this.pos_y = pos_y;
	}

	public void preSetPos_x(int pos_x)
	{
		this.pos_x = Board.boardLane[pos_x][0];		
	}

	public void preSetPos_y(int pos_y)
	{
		this.pos_y = Board.boardLane[0][pos_y];

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
}
