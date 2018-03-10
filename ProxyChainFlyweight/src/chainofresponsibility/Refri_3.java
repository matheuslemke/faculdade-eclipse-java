package chainofresponsibility;

public class Refri_3 implements Maquina
{
	private double valor = 1;
	
	@Override
	public void processarRequisicao(double valor)
	{
		if(valor == this.valor)
			System.out.println("Refri 3!");
		else
			System.out.println("Erro!");

	}

}
