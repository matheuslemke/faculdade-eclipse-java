/**
 * Equipe faustao
 * 
 * Alunos: Anderson, Lucas Didur, Lucas Padilha
 * 
 * Desenvolvedor principal: Anderson
 */

import java.util.LinkedList;
import java.util.Scanner;

enum Estado
{
	ORIENTACAO, SEPARADOR, VERTICE, ARESTA;
}

enum Cor
{
	BRANCO, CINZA, PRETO;
}

class Aresta
{
	private int indice;

	public Aresta(int indice)
	{
		super();
		this.indice = indice;
	}

	public int getIndice()
	{
		return indice;
	}

	public void setIndice(int indice)
	{
		this.indice = indice;
	}
}

class Vertice
{
	private String nome;
	private int descoberta;
	private int finalizacao;
	private int pai;
	private LinkedList<Aresta> adj = new LinkedList<>();
	private Cor cor;

	public Vertice(String nome)
	{
		super();
		this.nome = nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getNome()
	{
		return nome;
	}

	public LinkedList<Aresta> getAdj()
	{
		return adj;
	}

	public void setAdj(LinkedList<Aresta> adj)
	{
		this.adj = adj;
	}

	public int getDescoberta()
	{
		return descoberta;
	}

	public void setDescoberta(int descoberta)
	{
		this.descoberta = descoberta;
	}

	public int getFinalizacao()
	{
		return finalizacao;
	}

	public void setFinalizacao(int finalizacao)
	{
		this.finalizacao = finalizacao;
	}

	public int getPai()
	{
		return pai;
	}

	public void setPai(int pai)
	{
		this.pai = pai;
	}

	public Cor getCor()
	{
		return cor;
	}

	public void setCor(Cor cor)
	{
		this.cor = cor;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(" ");
		sb.append(descoberta);
		sb.append("/");
		sb.append(finalizacao);
		sb.append(" ");
		return sb.toString();
	}
}

public class Ts
{
	private static LinkedList<String> ordem = new LinkedList<>();
	private static int tempo = 0;

	public static int procurarIndicePeloNome(Vertice[] vertices, String nome)
	{
		int vertice1 = -1;

		for (int i = 0; i < vertices.length; i++)
		{
			if (!vertices[i].getNome().equals(nome))
				continue;
			vertice1 = i;
		}

		return vertice1;
	}

	public static void dfs(Vertice[] vertices)
	{
		if (vertices == null)
			return;

		// Inicio do algoritmo dfs
		for (Vertice vertice : vertices)
		{
			vertice.setCor(Cor.BRANCO);
			vertice.setPai(-1);
		}

		for (int i = 0; i < vertices.length; i++)
		{
			if (vertices[i].getCor().equals(Cor.BRANCO))
				dfsVisit(vertices, i);
		}
	}

	public static void dfsVisit(Vertice[] vertices, int vertice)
	{
		tempo++;
		vertices[vertice].setDescoberta(tempo);
		vertices[vertice].setCor(Cor.CINZA);

		// Para cada aresta na lista de adjacencia de 'vertice'
		for (Aresta adj : vertices[vertice].getAdj())
		{
			// Chamada recursiva para dfs-visit
			if (vertices[adj.getIndice()].getCor().equals(Cor.CINZA))
			{
				ordem.clear();
				ordem.add("ciclo");
			}
			else if (vertices[adj.getIndice()].getCor().equals(Cor.BRANCO))
			{
				vertices[adj.getIndice()].setPai(vertice);
				dfsVisit(vertices, adj.getIndice());
			}

		}

		vertices[vertice].setCor(Cor.PRETO);
		tempo++;
		vertices[vertice].setFinalizacao(tempo);
		ordem.addFirst(vertices[vertice].getNome());
	}

	public static void main(String[] args)
	{

		Scanner in = new Scanner(System.in);

		Estado estadoAnterior = Estado.ORIENTACAO;
		Estado estado = Estado.ORIENTACAO;
		LinkedList<Vertice> ListaVertices = new LinkedList<>();
		Vertice[] vertices = null;

		int orientado = -1;

		while (in.hasNext())
		{
			String linha = in.nextLine();

			if (linha.equals("#"))
			{
				if (estadoAnterior == Estado.ORIENTACAO)
					estado = Estado.VERTICE;
				if (estadoAnterior == Estado.VERTICE)
				{
					vertices = new Vertice[ListaVertices.size()];
					vertices = ListaVertices.toArray(vertices);
					estado = Estado.ARESTA;
				}

				continue;
			}
			else if (linha.equals("?"))
				break;

			switch (estado)
			{
			case ORIENTACAO:
				orientado = Integer.valueOf(linha);
				estadoAnterior = Estado.ORIENTACAO;
				break;

			case VERTICE:
				ListaVertices.add(new Vertice(linha));
				estadoAnterior = Estado.VERTICE;
				break;

			case ARESTA:
				estadoAnterior = Estado.ARESTA;

				String[] info = linha.split(" ");

				int vertice1 = procurarIndicePeloNome(vertices, info[0]);
				int vertice2 = procurarIndicePeloNome(vertices, info[1]);

				if (orientado == 1)
				{
					vertices[vertice1].getAdj().addLast(new Aresta(vertice2));
					vertices[vertice2].getAdj().addLast(new Aresta(vertice1));
				}
				else if (orientado == 2)
				{
					vertices[vertice1].getAdj().addLast(new Aresta(vertice2));
				}
				break;
			}
		}

		dfs(vertices);

		if (ordem.contains("ciclo"))
			System.out.print("ciclo");

		else
		{
			for (int i = 0; i < ordem.size(); i++)
			{
				System.out.print(ordem.get(i) + " ");
			}
		}
	}
}