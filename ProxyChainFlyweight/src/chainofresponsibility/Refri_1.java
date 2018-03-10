package chainofresponsibility;

public class Refri_1 implements Maquina
{

	private double valor = .25;
	private Maquina sucessor = new Refri_2();

	@Override
	public void processarRequisicao(double valor)
	{
		if(valor == this.valor)
			System.out.println("Refri 1!");
		else
			sucessor.processarRequisicao(valor);

	}
}
