package chainofresponsibility;

public class Refri_2 implements Maquina
{
	private double valor = .5;
	private Maquina sucessor = new Refri_3();


	@Override
	public void processarRequisicao(double valor)
	{
		if (valor == this.valor)
			System.out.println("Refri 2!");
		else
			sucessor.processarRequisicao(valor);

	}

}
