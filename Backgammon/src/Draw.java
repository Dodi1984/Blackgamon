import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Draw extends JFrame
{		
	private static final long serialVersionUID = 1L;		
	private Board board = new Board(1, 1, BufferedImage.TYPE_INT_ARGB);
	private Image dbImage;
	private Graphics dbGraphics;		
	private ArrayList<Chip> chip = new ArrayList<Chip>();
	
	public Draw()
	{
		startGame();
		// Game and window properties
		addMouseListener(new MouseEvents());
		setTitle("BackGammon Game");
		setSize(1900, 1000);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void startGame()
	{
		// initial placement for white Chips
		for (int i = 0; i < 15; i++)
		{
			if (i<=4)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).setQuadrant(1);
				chip.get(i).setPos_x(0);
				chip.get(i).setPos_y(i+1);
			}
			else if (i<=6)
			{				
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).setQuadrant(2);
				chip.get(i).setPos_x(5);
				chip.get(i).setPos_y(i-4);
			}
			else if (i<=11)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).setQuadrant(3);
				chip.get(i).setPos_x(5);
				chip.get(i).setPos_y(i-6);
			}
			else if (i<=14)
			{
				chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
				chip.get(i).setQuadrant(4);
				chip.get(i).setPos_x(1);
				chip.get(i).setPos_y(i-11);
			}
		}
		
		// for testing purposes
//		chip.add(new Chip(1, 1, BufferedImage.TYPE_INT_ARGB, true));
//		chip.get(12).setQuadrant(4);
//		chip.get(12).setPos_x(1);
//		chip.get(12).setPos_y(1);
				
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
//		g.drawImage(chip.get(0).getBi(), chip.get(0).getPos_x(), chip.get(0).getPos_y(), 75, 75, null);
		
		for (int i = 0; i < chip.size(); i++)
		{				
			g.drawImage(chip.get(i).getBi(), chip.get(i).getPos_x(), chip.get(i).getPos_y(), 75, 75, null);
		}
		
		g.drawString("Rolled : ", 900, 990);

		repaint();
	}
	
	
}
// o sa trebuiasca sa iterez prin obiecte si sa verific pozitiile de x si de y cele mai apropiate de locul in care fac click cu mouse-ul










