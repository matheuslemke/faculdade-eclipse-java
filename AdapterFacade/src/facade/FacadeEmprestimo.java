package facade;

public class FacadeEmprestimo
{
	private ClienteBanco cliente;
	private Banco banco;
	private Emprestimo emprestimo;
	private Credito credito;

	public FacadeEmprestimo()
	{
		// TODO Auto-generated constructor stub
	}

	public FacadeEmprestimo(ClienteBanco cliente, Banco banco,
			Emprestimo emprestimo, Credito credito)
	{
		super();
		this.cliente = cliente;
		this.banco = banco;
		this.emprestimo = emprestimo;
		this.credito = credito;
	}

	public boolean isEmprestimoPossivel(double valor)
	{
		if (banco.isEconomiaSuficiente(cliente)
				&& emprestimo.analiseEmprestimo(cliente)
				&& credito.analiseCredito(cliente))
		{
			return true;
		}
		return false;
	}
}
