package br.unicentro.lod.domain;

public class CidadeSUS
{
	private String nomeCidade;
	private String nomeEstado;
	private String populacao;
	private int nMedicosSUS;
	private double razaoLeitosSUS;

	public CidadeSUS()
	{
		// TODO Auto-generated constructor stub
	}

	public CidadeSUS(String nomeCidade, String nomeEstado, String populacao,
			int nMedicosSUS, double razaoLeitosSUS)
	{
		super();
		this.nomeCidade = nomeCidade;
		this.nomeEstado = nomeEstado;
		this.populacao = populacao;
		this.nMedicosSUS = nMedicosSUS;
		this.razaoLeitosSUS = razaoLeitosSUS;
	}

	public String getNomeCidade()
	{
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade)
	{
		this.nomeCidade = nomeCidade;
	}

	public String getNomeEstado()
	{
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado)
	{
		this.nomeEstado = nomeEstado;
	}

	public String getPopulacao()
	{
		return populacao;
	}

	public void setPopulacao(String populacao)
	{
		this.populacao = populacao;
	}

	public int getnMedicosSUS()
	{
		return nMedicosSUS;
	}

	public void setnMedicosSUS(int nMedicosSUS)
	{
		this.nMedicosSUS = nMedicosSUS;
	}

	public double getRazaoLeitosSUS()
	{
		return razaoLeitosSUS;
	}

	public void setRazaoLeitosSUS(double razaoLeitosSUS)
	{
		this.razaoLeitosSUS = razaoLeitosSUS;
	}

	public String toString()
	{
		return getNomeCidade() + "  " + getNomeEstado() + "  " + getPopulacao();
	}

}
