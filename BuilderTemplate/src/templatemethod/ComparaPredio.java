package templatemethod;

import java.util.Comparator;

public class ComparaPredio implements Comparator<Predio>
{

	@Override
	public int compare(Predio arg0, Predio arg1)
	{
		if (arg0.getAltura() > arg1.getAltura())
			return 1;
		if (arg0.getAltura() < arg1.getAltura())
			return -1;
		return 0;
	}

}
