package memento;

public class Cliente
{

	public static void main(String[] args)
	{
		Calculadora c = new Calculadora();

		System.out.println(c.soma(1, 1));
		c.salvarMemento();

		System.out.println(c.subtracao(2, 1));
		c.salvarMemento();

		// Quando vou desfazer, n�o salvo o memento, somente chamo a fun��o
		// desfazer. � poss�vel implementar uma vers�o de salvamento autom�tico,
		// por�m o controle da opera��o atual da calculadora � mais complexa.
		System.out.println(c.multiplicacao(2, 3));

		c.desfazer();

		// Opera��o que estava no memento antes da ultima opera��o
		System.out.println(c.getOperacao());

		System.out.println(c.divisao(5, 2));
		c.salvarMemento();

		System.out.println(c.multiplicacao(2, 7));

		c.desfazer();
		System.out.println(c.getOperacao());

		c.desfazer();
		System.out.println(c.getOperacao());

	}

}
