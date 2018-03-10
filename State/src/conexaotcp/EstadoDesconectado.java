package conexaotcp;

public class EstadoDesconectado implements Estado
{
	private final ConexaoTCP cx;

	public EstadoDesconectado(ConexaoTCP cx)
	{
		super();
		this.cx = cx;
	}

	@Override
	public void abrir()
	{
		cx.setEstado(cx.getCONECTADO());
		System.out.println("Conexão iniciada!");
	}

	@Override
	public void fechar()
	{
		System.out.println("ERRO: Conexão já se encontra fechada!");
	}

	@Override
	public void enviar(String msg)
	{
		System.out.println("ERRO: Conexão fechada! Impossível enviar!");
	}

}
