import java.util.Random;

public class Game extends Thread
{
	private int mouseX;
	private int mouseY;
	private int chipInitialX;
	private int chipInitialY;
	private boolean mousePressed = false;
	private boolean[][] relPositions = new boolean[24][6];
	private Chip c;
	private boolean aiTurn=false;
	Dice dice = new Dice();
	private int dice1;
	private int dice2;
	Random rand = new Random();
	private int random;
	private int max = 29;
	private int min = 15;
	public int getRandomChip()
	{
		random = rand.nextInt(max-min)+min;
		return this.random;
	}
	public void run()
	{
		setInitialRelativePositions();
		while (true)
		{
			dice1=dice.getRandomDice();
			dice2=dice.getRandomDice();
			int randomChip1 = getRandomChip();
			int randomChip2 = getRandomChip();
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
						&& Draw.chip.get(i).isWhite()
						&& aiTurn==false)
				{
					if (mousePressed
							&& ((mouseY < Draw.chip.get(i).getPos_y() + 78) && (mouseY > Draw.chip.get(i).getPos_y())))
					{
						chipInitialX = Draw.chip.get(i).getRelPos_x(); // read
						chipInitialY = Draw.chip.get(i).getRelPos_y();	// initial
																		// x and
																		// y
																		// relative
																		// positions
						
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
											for (int k = 1; k <= 5; k++)
											{												
												if (!relPositions[j][k])// check if the place is taken, if not he will enter
												{
																									
														Draw.chip.get(i).preSetPos(j, k);		// to jump in place
														Draw.chip.get(i).setRelPos_x(j);
														Draw.chip.get(i).setRelPos_y(k);
														relPositions[j][k] = true;
														relPositions[chipInitialX][chipInitialY] = false;
														k=6;
														//setAiTurn(true);			//enables AI
												}
												else  // if it`s taken he will 
												{														
													
												}
											}
										} 
										else
										{
											Draw.chip.get(i).preSetPos(chipInitialX, chipInitialY);
										}
									}
								}
							}
						}
					}
				}
			}
			// loop
			if (aiTurn)
			{				
				Draw.chip.get(randomChip1).preSetPos(Draw.chip.get(randomChip1).getRelPos_x()+dice1, 1);
				Draw.chip.get(randomChip2).preSetPos(Draw.chip.get(randomChip2).getRelPos_x()+dice2, 1);				
				setAiTurn(false);
				
			}
		}
	}

	public void setInitialRelativePositions()
	{
		for (int i = 0; i < Draw.chip.size(); i++)
		{
			relPositions[Draw.chip.get(i).getRelPos_x()][Draw.chip.get(i).getRelPos_y()] = true;
		}
	}

	public boolean isAiTurn()
	{
		return aiTurn;
	}

	public void setAiTurn(boolean aiTurn)
	{
		this.aiTurn = aiTurn;
	}


}
