import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.Exchanger;

import javax.swing.JFrame;

public class Draw extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Board board = new Board(1, 1, BufferedImage.TYPE_INT_ARGB);
	private Image dbImage;
	private Graphics dbGraphics;
	public static ArrayList<Chip> chip = new ArrayList<Chip>();
	public static MouseEvents mouse = new MouseEvents();
	final Exchanger<String> exchanger = new Exchanger<String>();
	private Game game = new Game();

	public Draw()
	{
		startGame();
		// starting game thread
		game.start();
		//game.setBoard(board);
		// Game and window properties
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		setTitle("BackGammon Game");
		setSize(1900, 1000);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void startGame()
	{
		// initial placement for white Chips
		for (int i = 0; i < 30; i++)
		{
			if (i <= 1)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).preSetPos(0, i + 1);

			}
			else if (i <= 6)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).preSetPos(11, i - 1);
			}
			else if (i <= 9)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).preSetPos(16, i - 6);
			}
			else if (i <= 14)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).preSetPos(18, i - 9);

			}
//			// initial placement for Black chips
			else if (i <= 16)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, false));
				chip.get(i).preSetPos(23, i - 14);
			}
			else if (i <= 21)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, false));
				chip.get(i).preSetPos(5, i - 16);
			}
			else if (i <= 24)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, false));
				chip.get(i).preSetPos(7, i - 21);
			}
			else if (i <= 29)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, false));
				chip.get(i).preSetPos(12, i - 24);
			}
		}
		// initial placement for Black chips
		
		// for testing purposes
//		chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, false));
//		chip.get(0).preSetPos(20, 5);

	}

	public void paint(Graphics g)
	{

		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(board.getBi(), 0, 0, 1900, 1000, null);

		for (int i = 0; i < chip.size(); i++)
		{
			g.drawImage(chip.get(i).getBi(), chip.get(i).getPos_x(), chip.get(i).getPos_y(), 75, 75, null);
		}
		g.drawString("Rolled : ", 900, 990);		
		
		repaint();
	}
}
