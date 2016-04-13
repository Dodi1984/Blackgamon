import java.util.ArrayList;

public class Game extends Thread
{
	private int mouseX;
	private int mouseY;
	private boolean mousePressed = false;
	private boolean este = false;

	public void run()
	{
		//System.out.println(Draw.chip.get(0).getPos_x());
		
		while (true)
		{
			// loop
			mouseX = Draw.mouse.getX();
			mouseY = Draw.mouse.getY();
			mousePressed = Draw.mouse.isClicked();
//System.out.println();
			for (int i = 0; i < Draw.chip.size(); i++)
			{
				if (mousePressed && ((mouseX < Draw.chip.get(0).getPos_x()+78) && (mouseX > Draw.chip.get(0).getPos_x())) )  
				{					
					if (mousePressed && ((mouseY < Draw.chip.get(0).getPos_y()+78) && (mouseY > Draw.chip.get(0).getPos_y())))
					{						
						System.out.println("merge");
					}
					
				}
			}
			
			
			
			// loop
		}		
	}
}
