package conexaotcp;

public class EstadoTransmitindo implements Estado
{
	private final ConexaoTCP cx;

	public EstadoTransmitindo(ConexaoTCP cx)
	{
		super();
		this.cx = cx;
	}

	@Override
	public void abrir()
	{
		System.out.println("ERRO: Conex�o j� est� aberta e em transmiss�o!");
	}

	@Override
	public void fechar()
	{
		cx.setEstado(cx.getDESCONECTADO());
		System.out.println("Conex�o encerrada!");
	}

	@Override
	public void enviar(String msg)
	{
		System.out.println("ERRO: Conex�o est� no meio de uma transmiss�o!");
	}

}
