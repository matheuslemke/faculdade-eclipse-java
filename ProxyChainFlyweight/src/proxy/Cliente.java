package proxy;

public class Cliente
{

	public static void main(String[] args)
	{
		Pagina p1 = new ProxyPagina("Google");
		Pagina p2 = new ProxyPagina("Globo");
		Pagina p3 = new ProxyPagina("Facebook");
		p2.acessar();
		p1.acessar();
		p3.acessar();

	}

}
