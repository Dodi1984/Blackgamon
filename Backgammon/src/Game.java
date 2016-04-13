public class Game extends Thread
{
	private int mouseX;
	private int mouseY;
	private boolean mousePressed = false;
	private boolean este = false;	
	
	public void run()
	{		
		// initial Chips state
		
		
		
		while (true)
		{
			// loop
			mouseX = Draw.mouse.getX();
			mouseY = Draw.mouse.getY();
			mousePressed = Draw.mouse.isClicked();
			//System.out.println();
			for (int i = 0; i < Draw.chip.size(); i++)
			{				
				if (mousePressed && ((mouseX < Draw.chip.get(i).getPos_x()+78) && (mouseX > Draw.chip.get(i).getPos_x())) )  
				{						
					if (mousePressed && ((mouseY < Draw.chip.get(i).getPos_y()+78) && (mouseY > Draw.chip.get(i).getPos_y())))
					{						
						//System.out.println(Draw.chip.get(i).getPos_x());
						Draw.chip.get(i).setPos_x(mouseX-35);
						Draw.chip.get(i).setPos_y(mouseY-35);
					}
					
				}
			}
			
			
			
			// loop
		}		
	}
	public void setChipState()
	{
		
	}
}
