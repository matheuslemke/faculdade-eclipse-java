package subtractorvisitor;

public class Cliente
{

	public static void main(String[] args)
	{
		IntegerContainer inteiro = new IntegerContainer(1);
		DoubleContainer doouble = new DoubleContainer(1.5);

		Visitor subtrator = new SubtractVisitor();
		Visitor somador = new SumVisitor();

		System.out.println("Inteiro");
		inteiro.accept(somador);
		System.out.println("Depois da soma: " + inteiro.getNumber());

		inteiro.accept(subtrator);
		System.out.println("Depois da subtração: " + inteiro.getNumber());

		System.out.println("\nDouble");
		doouble.accept(somador);
		System.out.printf("Depois da soma: %.2f\n", doouble.getNumber());

		doouble.accept(subtrator);
		System.out.printf("Depois da subtração: %.2f", doouble.getNumber());
	}

}
