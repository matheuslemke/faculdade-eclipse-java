package bridge;

public class Sony implements TV
{

	@Override
	public void on()
	{
		System.out.println("TV Sony ligada!");
	}

	@Override
	public void off()
	{
		System.out.println("TV Sony desligada!");
	}

	@Override
	public void tuneChannel(int channel)
	{
		System.out.println("TV Sony no canal " + channel + "!");
	}

}
