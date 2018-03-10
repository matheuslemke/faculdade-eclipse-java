package conexaotcp;

public class ConexaoTCP
{
	private final Estado CONECTADO = new EstadoConectado(this);
	private final Estado DESCONECTADO = new EstadoDesconectado(this);
	private final Estado TRANSMITINDO = new EstadoTransmitindo(this);
	private Estado estado = DESCONECTADO;

	public Estado getEstado()
	{
		return estado;
	}

	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}

	public Estado getCONECTADO()
	{
		return CONECTADO;
	}

	public Estado getDESCONECTADO()
	{
		return DESCONECTADO;
	}

	public Estado getTRANSMITINDO()
	{
		return TRANSMITINDO;
	}

	public void abrir()
	{
		estado.abrir();
	}

	public void fechar()
	{
		estado.fechar();
	}

	public void enviar(String msg)
	{
		estado.enviar(msg);
	}

}
