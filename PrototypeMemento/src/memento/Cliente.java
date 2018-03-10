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

		// Quando vou desfazer, não salvo o memento, somente chamo a função
		// desfazer. É possível implementar uma versão de salvamento automático,
		// porém o controle da operação atual da calculadora é mais complexa.
		System.out.println(c.multiplicacao(2, 3));

		c.desfazer();

		// Operação que estava no memento antes da ultima operação
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
