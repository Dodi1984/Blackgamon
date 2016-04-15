import java.util.Random;

public class Dice
{
	Random rand = new Random();
	private int random;
	private int max = 6;
	private int min = 1;
	public int getRandomDice()
	{
		random = rand.nextInt(max-min)+min;
		return this.random;
	}
}
