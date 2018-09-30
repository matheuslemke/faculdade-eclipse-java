package maquina;

public class Estado
{

	private String nome;
	private Character[] caracteresLeitura;
	private Character[] caracteresEscrita;
	private Movimento[] movimentos;
	private String[] proximosEstados;

	public Estado()
	{
	}

	public Estado(String nome, Character[] caracteresLeitura,
			Character[] caracteresEscrita, Movimento[] movimentos,
			String[] proximosEstados)
	{
		super();
		this.nome = nome;
		this.caracteresLeitura = caracteresLeitura;
		this.caracteresEscrita = caracteresEscrita;
		this.movimentos = movimentos;
		this.proximosEstados = proximosEstados;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Character[] getCaracteresLeitura()
	{
		return caracteresLeitura;
	}

	public void setCaracteresLeitura(Character[] caracteresLeitura)
	{
		this.caracteresLeitura = caracteresLeitura;
	}

	public Character[] getCaracteresEscrita()
	{
		return caracteresEscrita;
	}

	public void setCaracteresEscrita(Character[] caracteresEscrita)
	{
		this.caracteresEscrita = caracteresEscrita;
	}

	public Movimento[] getMovimentos()
	{
		return movimentos;
	}

	public void setMovimentos(Movimento[] movimentos)
	{
		this.movimentos = movimentos;
	}

	public String[] getProximosEstados()
	{
		return proximosEstados;
	}

	public void setProximosEstados(String[] proximosEstados)
	{
		this.proximosEstados = proximosEstados;
	}

}
