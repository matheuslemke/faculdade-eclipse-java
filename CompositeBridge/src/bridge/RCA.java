package bridge;

public class RCA implements TV
{

	@Override
	public void on()
	{
		System.out.println("TV RCA ligada!");
	}

	@Override
	public void off()
	{
		System.out.println("TV RCA desligada!");
	}

	@Override
	public void tuneChannel(int channel)
	{
		System.out.println("TV RCA no canal " + channel + "!");
	}

}
