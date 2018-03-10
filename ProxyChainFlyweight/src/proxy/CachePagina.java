package proxy;

public class CachePagina
{
	private final int tamanho = 2;
	private PaginaConcreta[] vetor = new PaginaConcreta[tamanho];

	public void add(PaginaConcreta p)
	{
		remove();
		vetor[tamanho - 1] = p;

	}

	public PaginaConcreta remove()
	{
		PaginaConcreta p = vetor[0];
		for (int i = 0; i < tamanho - 1; i++)
		{
			vetor[i] = vetor[i + 1];
		}
		vetor[tamanho - 1] = null;
		return p;
	}

	public int buscar(String name)
	{
		for (int i = 0; i < vetor.length; i++)
		{
			if (vetor[i] != null)
				if (vetor[i].getName() == name)
					return i;

		}
		return -1;
	}

	public void atribuirPrimeiro(int i)
	{
		PaginaConcreta aux = vetor[i];
		for (int j = i; j > 0; j--)
		{
			vetor[i] = vetor[i - 1];
		}
		vetor[0] = aux;
	}

	public PaginaConcreta getPrimeiro()
	{
		return vetor[0];
	}

}
