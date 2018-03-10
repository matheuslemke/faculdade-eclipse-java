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
		System.out.println("ERRO: Conexão já está aberta e em transmissão!");
	}

	@Override
	public void fechar()
	{
		cx.setEstado(cx.getDESCONECTADO());
		System.out.println("Conexão encerrada!");
	}

	@Override
	public void enviar(String msg)
	{
		System.out.println("ERRO: Conexão está no meio de uma transmissão!");
	}

}
