import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chip
{
	private int pos_x;
	private int pos_y;
	private int relPos_x;
	private int relPos_y;
	private boolean selected = false;
	private boolean isSelectable = false;
	private boolean isWhite;
	private boolean isOut = false;
	private boolean isTaken = false;

	public boolean isOut()
	{
		return isOut;
	}

	public void setOut(boolean isOut)
	{
		this.isOut = isOut;
	}

	public boolean isTaken()
	{
		return isTaken;
	}

	public void setTaken(boolean isTaken)
	{
		this.isTaken = isTaken;
	}

	public boolean isWhite()
	{
		return isWhite;
	}

	private BufferedImage bi;

	public Chip(int width, int height, int imageType, boolean isWhite)
	{
		this.isWhite = isWhite;
		this.bi = new BufferedImage(width, height, imageType);
		try
		{
			if (isWhite)
			{
				this.bi = ImageIO.read(getClass().getResourceAsStream("/pul2.png"));
				this.isWhite=true;
			} else
			{
				this.bi = ImageIO.read(getClass().getResourceAsStream("/pul1.png"));
				this.isWhite=false;
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

	public void preSetPos(int pos_x, int pos_y)
	{
		this.pos_x = Board.boardLane[pos_x][0];
		relPos_x = pos_x;
		this.pos_y = Board.boardLane[pos_x][pos_y];
		relPos_y = pos_y;
	}

	public int getRelPos_x()
	{
		return relPos_x;
	}

	public void setRelPos_x(int relPos_x)
	{
		this.relPos_x = relPos_x;
	}

	public int getRelPos_y()
	{
		return relPos_y;
	}

	public void setRelPos_y(int relPos_y)
	{
		this.relPos_y = relPos_y;
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
