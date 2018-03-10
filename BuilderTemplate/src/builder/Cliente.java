package builder;

public class Cliente
{

	public static void main(String[] args)
	{
		ConstrutorDeCasas cc = new ConstrutorDeCasas();
		ConstrutorDePredios cp = new ConstrutorDePredios();

		Diretor d = new Diretor();
		d.addConstrutor(cc);
		d.addConstrutor(cp);

		d.construir();

		cc.getCasa();
		cp.getPredio();

	}

}
