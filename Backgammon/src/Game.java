public class Game extends Thread
{
	private int mouseX;
	private int mouseY;
	private int chipInitialX;
	private int chipInitialY;
	private boolean mousePressed = false;
	public static int[][] relPositions = new int[24][6];

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
						&& ((mouseX < Draw.chip.get(i).getPos_x() + 78) && (mouseX > Draw.chip.get(i).getPos_x()))
						&& Draw.chip.get(i).isWhite())
				{
					if (mousePressed
							&& ((mouseY < Draw.chip.get(i).getPos_y() + 78) && (mouseY > Draw.chip.get(i).getPos_y())))
					{
						chipInitialX = Draw.chip.get(i).getRelPos_x();
						chipInitialY = Draw.chip.get(i).getRelPos_y();
						while (mousePressed)
						{
							mousePressed = Draw.mouse.isClicked();
							Draw.chip.get(i).setPos_x(Draw.mouse.getX() - 35);
							Draw.chip.get(i).setPos_y(Draw.mouse.getY() - 35);
							System.out.println();
						}
						// Jump to position

						for (int j = 0; j < Board.boardLane.length; j++)
						{
							if ((Draw.chip.get(i).getPos_x() >= Board.boardLane[j][0]
									&& Draw.chip.get(i).getPos_x() < Board.boardLane[j][0] + 39)
									|| Draw.chip.get(i).getPos_x() <= Board.boardLane[j][0]
											&& Draw.chip.get(i).getPos_x() > Board.boardLane[j][0] - 39)
							{
								for (int j2 = 1; j2 < Board.boardLane[j].length; j2++)
								{
									if ((Draw.chip.get(i).getPos_y() >= Board.boardLane[j][j2]
											&& Draw.chip.get(i).getPos_y() < Board.boardLane[j][j2] + 39)
											|| Draw.chip.get(i).getPos_y() <= Board.boardLane[j][j2]
													&& Draw.chip.get(i).getPos_y() > Board.boardLane[j][j2] - 39)
									{
										if (chipInitialX <= j) // to go only
																// forward
										{
											Draw.chip.get(i).preSetPos(j, j2);
											Draw.chip.get(i).setRelPos_x(j);

										} else
										{
											Draw.chip.get(i).preSetPos(chipInitialX, chipInitialY);
										}

									}
								}
							}
						}
						// can go only in one direction
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
