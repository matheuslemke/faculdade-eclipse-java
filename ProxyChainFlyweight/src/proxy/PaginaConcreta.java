package proxy;

public class PaginaConcreta implements Pagina
{
	private String name;

	public PaginaConcreta(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public void acessar()
	{
		System.out.println("Página " + name);

	}

}
