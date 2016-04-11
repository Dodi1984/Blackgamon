import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEvents extends MouseAdapter
{
	private boolean isClicked = false;
	private int x;
	private int y;

	@Override
	public void mouseReleased(MouseEvent e)
	{
		setClicked(false);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		setClicked(true);		
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		System.out.println(x+y);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		System.out.println(x+y);
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public boolean isClicked()
	{
		return isClicked;
	}

	public void setClicked(boolean isClicked)
	{
		this.isClicked = isClicked;
	}

}
