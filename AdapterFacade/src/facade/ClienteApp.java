package facade;

public class ClienteApp
{

	public static void main(String[] args)
	{
		ClienteBanco c = new ClienteBanco("Juarez");
		FacadeEmprestimo f = new FacadeEmprestimo(c, new Banco(), new Emprestimo(),
				new Credito());
		System.out.println(f.isEmprestimoPossivel(200));
	}

}
