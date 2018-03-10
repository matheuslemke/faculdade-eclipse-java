package conexaotcp;

public class EstadoConectado implements Estado
{
	private final ConexaoTCP cx;

	public EstadoConectado(ConexaoTCP cx)
	{
		super();
		this.cx = cx;
	}

	@Override
	public void abrir()
	{
		System.out.println("ERRO: Conex�o j� est� aberta!");
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
		cx.setEstado(cx.getTRANSMITINDO());
		System.out.println("Transmitindo mensagem: \n" + msg);
	}
}
