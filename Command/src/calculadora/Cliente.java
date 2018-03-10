package calculadora;

public class Cliente
{

	public static void main(String[] args)
	{
		Calculadora calculadora = new Calculadora(5, 2);

		Operacao soma = new Soma(calculadora);
		Operacao subtracao = new Subtracao(calculadora);
		Operacao divisao = new Divisao(calculadora);
		Operacao multiplicacao = new Multiplicacao(calculadora);

		Macro macro = new Macro();
		macro.addOperacao(soma);
		macro.addOperacao(subtracao);
		macro.addOperacao(multiplicacao);
		macro.addOperacao(divisao);

		macro.executeAll();

		System.out.println();
		
		calculadora.setX(10);

		macro.executeAll();

	}

}
