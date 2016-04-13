public class Game extends Thread
{
	private int mouseX;
	private int mouseY;
	private boolean mousePressed = false;
	Board board;
	public void run()
	{
		

		while (true)
		{
			//
			// loop
			mouseX = Draw.mouse.getX();
			mouseY = Draw.mouse.getY();
			mousePressed = Draw.mouse.isClicked();
			System.out.println();
			for (int i = 0; i < Draw.chip.size(); i++)
			{
				if (mousePressed
						&& ((mouseX < Draw.chip.get(i).getPos_x() + 78) 
								&& (mouseX > Draw.chip.get(i).getPos_x())))
				{
					if (mousePressed
							&& ((mouseY < Draw.chip.get(i).getPos_y() + 78) 
									&& (mouseY > Draw.chip.get(i).getPos_y())))
					{
						while (mousePressed)
						{			
							mousePressed= Draw.mouse.isClicked();
							Draw.chip.get(i).setPos_x(Draw.mouse.getX() - 35);
							Draw.chip.get(i).setPos_y(Draw.mouse.getY() - 35);	
							System.out.println();
						}
						
						
					}

				}
			}

			// loop
		}
	}

	public void setChipState()
	{
		
	}

	public void setBoard(Board board)
	{
		this.board = board;
	}
}
