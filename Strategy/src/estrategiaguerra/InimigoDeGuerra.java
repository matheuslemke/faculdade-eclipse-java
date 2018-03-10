package estrategiaguerra;

public class InimigoDeGuerra
{
	private int exercito;
	private boolean nuclear;

	public InimigoDeGuerra(int exercito, boolean nuclear)
	{
		super();
		this.exercito = exercito;
		this.nuclear = nuclear;
	}

	public int getExercito()
	{
		return exercito;
	}

	public void setExercito(int exercito)
	{
		this.exercito = exercito;
	}

	public boolean isNuclear()
	{
		return nuclear;
	}

	public void setNuclear(boolean nuclear)
	{
		this.nuclear = nuclear;
	}

}
