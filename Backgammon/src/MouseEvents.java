import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEvents extends MouseAdapter
{
	private boolean isClicked = false;
	private int x;
	private int y;
	@Override
	public void mouseMoved(MouseEvent arg0)
	{			
		x = arg0.getX();
		y = arg0.getY();
		System.out.println(x + y);
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
		isClicked = true;
		System.out.println("clicked");
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		isClicked = false;
		System.out.println("released");
	}
	public boolean isClicked()
	{
		return isClicked;
	}
	
	
	
	
	
	
}
