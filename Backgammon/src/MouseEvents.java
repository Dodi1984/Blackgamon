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
		System.out.println("released");
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		setClicked(true);
		System.out.println("clicked");
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
	}

	public int mouseGetX()
	{
		return this.x;
	}

	public int mouseGetY()
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
