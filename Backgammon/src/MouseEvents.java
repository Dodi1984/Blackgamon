import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MouseEvents extends MouseAdapter
{
	public void mousePressed(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + " , " + y);
	}

	public void mouseReleased(MouseEvent e)
	{

	}
}
