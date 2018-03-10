package calculadora;

import java.util.ArrayList;

public class Macro
{
	private ArrayList<Operacao> macro = new ArrayList<>();

	public void addOperacao(Operacao o)
	{
		macro.add(o);
	}

	public void executeAll()
	{
		for (Operacao operacao : macro)
		{
			System.out.println(operacao.getClass().getSimpleName() + " = "
					+ operacao.execute());
		}
	}
}
