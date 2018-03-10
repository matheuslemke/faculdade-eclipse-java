package prototype;

public class Retangulo implements Forma
{
	private double altura;
	private double largura;

	public Retangulo(double altura, double largura)
	{
		super();
		this.altura = altura;
		this.largura = largura;
	}

	@Override
	public double calculaArea()
	{
		return altura * largura;
	}

	@Override
	public Forma clonar()
	{
		return new Retangulo(altura, largura);
	}

	@Override
	public double getAltura()
	{
		return altura;
	}

	@Override
	public double getLargura()
	{
		return largura;
	}

	@Override
	public void setAltura(double altura)
	{
		this.altura = altura;
	}

	@Override
	public void setLargura(double largura)
	{
		this.largura = largura;
	}
}
