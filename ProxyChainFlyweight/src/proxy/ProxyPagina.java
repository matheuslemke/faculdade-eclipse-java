package proxy;

public class ProxyPagina implements Pagina
{
	private String name;
	private CachePagina cache = new CachePagina();

	public ProxyPagina(String name)
	{
		super();
		this.name = name;
	}

	@Override
	public void acessar()
	{
		int i = cache.buscar(name);
		if (i == -1)
		{
			System.out.println("Salvando...");
			cache.add((new PaginaConcreta(name)));
			acessar();
		}
		else
		{
			System.out.println("Acessando da cache");
			cache.atribuirPrimeiro(i);
			cache.getPrimeiro().acessar();
		}
	}
}
