import java.util.Random;

public class Dice
{
	Random rand = new Random();
	int random;
	int max = 6;
	int min = 1;
	public int getRandom()
	{
		random = rand.nextInt(max-min)+min;
		return this.random;
	}
}
