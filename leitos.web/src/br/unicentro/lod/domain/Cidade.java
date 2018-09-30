package br.unicentro.lod.domain;

public class Cidade
{

	private String gid;
	private String nomeCidade;
	private double razaoMedPrivados;
	private double razaoLeitos;

	public Cidade(String gid, String nomeCidade, double razaoMedPrivados,
			double razaoLeitos)
	{
		super();
		this.gid = gid;
		this.nomeCidade = nomeCidade;
		this.razaoMedPrivados = razaoMedPrivados;
		this.razaoLeitos = razaoLeitos;
	}

	public String getGid()
	{
		return gid;
	}

	public void setGid(String gid)
	{
		this.gid = gid;
	}

	public String getNomeCidade()
	{
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade)
	{
		this.nomeCidade = nomeCidade;
	}

	public double getRazaoMedPrivados()
	{
		return razaoMedPrivados;
	}

	public void setRazaoMedPrivados(double razaoMedPrivados)
	{
		this.razaoMedPrivados = razaoMedPrivados;
	}

	public double getRazaoLeitos()
	{
		return razaoLeitos;
	}

	public void setRazaoLeitos(double razaoLeitos)
	{
		this.razaoLeitos = razaoLeitos;
	}

	public String toString()
	{
		return getGid() + "  " + getNomeCidade();
	}
}