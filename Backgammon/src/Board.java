import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Board
{
	private boolean isTaken;
	// first quadrant positions
	public static int[][] firstQuadrantPositions = new int[6][6];
	// second quadrant positions
	public static int[][] secondQuadrantPositions = new int[6][6];
	// third quadrant positions
	public static int[][] thirdQuadrantPositions = new int[6][6];
	// fourth quadrant positions
	public static int[][] fourthQuadrantPositions = new int[6][6];
	private BufferedImage bi;

	public Board(int width, int height, int imageType)
	{
		this.bi = new BufferedImage(width, height, imageType);
		try
		{
			this.bi = ImageIO.read(getClass().getResourceAsStream("/Board.png"));

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		setPositions();
	}


	private void setPositions()
	{
		int x_offset = 102;
		int y_offset = 77;
		for (int i = 0; i < firstQuadrantPositions.length; i++)
		{
			firstQuadrantPositions[i][0] = 329 + x_offset * i;
			for (int j = 1; j < firstQuadrantPositions[i].length; j++)
			{
				firstQuadrantPositions[i][j] = 38 + y_offset * j;
			}
		}
		for (int i = 0; i < secondQuadrantPositions.length; i++)
		{
			secondQuadrantPositions[i][0] = 1009 + x_offset * i;
			for (int j = 1; j < secondQuadrantPositions[i].length; j++)
			{
				secondQuadrantPositions[i][j] = 38 + y_offset * j;
			}
		}
		for (int i = 0; i < thirdQuadrantPositions.length; i++)
		{
			thirdQuadrantPositions[i][0] = 1519-x_offset*i;
			for (int j = 1; j < thirdQuadrantPositions[i].length; j++)
			{
				thirdQuadrantPositions[i][j] = 930- y_offset*j;
			}
		}
		for (int i = 0; i < fourthQuadrantPositions.length; i++)
		{
			fourthQuadrantPositions[i][0] = 839-x_offset*i;
			for (int j = 1; j < fourthQuadrantPositions[i].length; j++)
			{
				fourthQuadrantPositions[i][j] = 930- y_offset*j;
			}
		}
	}

	public boolean isTaken()
	{
		return isTaken;
	}

	public void setTaken(boolean isTaken)
	{
		this.isTaken = isTaken;
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
