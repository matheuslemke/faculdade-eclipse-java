package gatoquantico;

public class Gato
{
	private final Estado VIVO = new EstadoVivo();
	private final Estado QUANTICO = new EstadoQuantico();
	private final Estado MORTO = new EstadoMorto();
	private Estado estado;

	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}

	public void miar()
	{
		estado.miar();
	}

	public Estado getVIVO()
	{
		return VIVO;
	}

	public Estado getQUANTICO()
	{
		return QUANTICO;
	}

	public Estado getMORTO()
	{
		return MORTO;
	}

	public Estado getEstado()
	{
		return estado;
	}

}
