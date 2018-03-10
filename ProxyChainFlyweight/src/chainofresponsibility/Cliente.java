package chainofresponsibility;

public class Cliente
{

	public static void main(String[] args)
	{
		Maquina m = new Refri_1();
		m.processarRequisicao(.25);
		m.processarRequisicao(.5);
		m.processarRequisicao(1);

	}

}
