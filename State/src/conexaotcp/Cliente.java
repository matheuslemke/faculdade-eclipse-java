package conexaotcp;

public class Cliente
{

	public static void main(String[] args)
	{
		ConexaoTCP c = new ConexaoTCP();
		c.abrir();
		c.enviar("Olá");
		c.fechar();
		
		System.out.println();
		c.enviar("Vai dar erro");
		c.fechar();
		c.abrir();
		c.abrir();

	}

}
