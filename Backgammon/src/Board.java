import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Board
{
	private boolean isTaken;

	// positions
	public static int[][] boardLane = new int[24][6]; // i should have positions
	private BufferedImage bi;
	// public static boolean[][] relPositions = new boolean[24][6];// de facut
	// // array-ul care
	// // tine
	// // pozitiile

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
		//
		for (int i = 0; i < boardLane.length; i++)
		{
			if (i <= 5)
			{
				boardLane[i][0] = 1519 - x_offset * i;

				for (int j = 1; j < boardLane[i].length; j++) /// cadranul 1
				{
					boardLane[i][j] = 38 + y_offset * j;
				}
			}

			else if (i > 5 && i <= 11)
			{
				boardLane[i][0] = 839 - x_offset * (i - 6);
				for (int j = 1; j < boardLane[i].length; j++) /// cadranul 2
				{
					boardLane[i][j] = 38 + y_offset * j;
				}
			} else if (i > 11 && i <= 17)
			{
				boardLane[i][0] = 329 + x_offset * (i - 12);
				for (int j = 1; j < boardLane[i].length; j++) /// cadranul 3
				{
					boardLane[i][j] = 930 - y_offset * j;
				}
			} else if (i > 17 && i <= 23)
			{
				boardLane[i][0] = 1009 + x_offset * (i - 18);
				for (int j = 1; j < boardLane[i].length; j++) /// cadranul 3
				{
					boardLane[i][j] = 930 - y_offset * j;
				}
			}

		}
		//
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
