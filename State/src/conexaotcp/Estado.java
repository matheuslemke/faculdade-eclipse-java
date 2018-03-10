package conexaotcp;

public interface Estado
{
	public void abrir();

	public void fechar();

	public void enviar(String msg);
}
