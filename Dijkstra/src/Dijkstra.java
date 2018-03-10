import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.text.html.parser.ParserDelegator;

enum Estado
{

	ORIENTACAO, SEPARADOR, VERTICE, ARESTA;
}

class Aresta
{

	private int indice;
	private double peso;

	public Aresta(int indice, double peso)
	{
		super();
		setIndice(indice);
		setPeso(peso);
	}

	public int getIndice()
	{
		return indice;
	}

	public void setIndice(int indice)
	{
		this.indice = indice;
	}

	public double getPeso()
	{
		return peso;
	}

	public void setPeso(double peso)
	{
		this.peso = peso;
	}
}

class Vertice
{

	private String nome;
	private double chave;
	private int pai;
	private LinkedList<Aresta> adj = new LinkedList<>();

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

	public double getChave()
	{
		return chave;
	}

	public void setChave(double descoberta)
	{
		this.chave = descoberta;
	}

	public int getPai()
	{
		return pai;
	}

	public void setPai(int pai)
	{
		this.pai = pai;
	}
}

public class Dijkstra
{

	public static LinkedList<Integer> dijkstra(Vertice[] vertices, int vertice)
	{
		LinkedList<Integer> S = new LinkedList<Integer>();

		if (vertices == null)
		{
			return S;
		}

		for (int i = 1; i < vertices.length; i++)
		{
			vertices[i].setChave(Double.MAX_VALUE);
			vertices[i].setPai(-1);
		}

		vertices[vertice].setChave(0);
		vertices[vertice].setPai(-1);

		ArrayList<Integer> q = new ArrayList<Integer>();

		for (int i = 0; i < vertices.length; i++)
		{
			q.add(i);
		}

		while (!q.isEmpty())
		{
			int min = extractMin(vertices, q);

			Vertice minVertice = vertices[min];

			for (Aresta adj : vertices[min].getAdj())
			{
				Vertice adjacente = vertices[adj.getIndice()];

				if (adjacente.getChave() > minVertice.getChave()
						+ adj.getPeso())
				{
					adjacente.setChave(minVertice.getChave() + adj.getPeso());
					adjacente.setPai(min);
				}
			}

			S.addLast(min);
		}

		return S;
	}

	// relax(u, v, w)
	// if v.d > u.d + w(u, v)
	// v.d = u.d + w(u, v)
	// v.pai = u

	private static int extractMin(Vertice[] vertices, ArrayList<Integer> q)
	{
		int min = 0;

		for (int vertice : q)
		{
			if (vertices[vertice].getChave() < vertices[min].getChave())
			{
				min = vertice;
			}
		}

		q.remove((Object) min);

		return min;
	}

	public static void imprimeCaminho(Vertice[] vertices, int indice,
			ArrayList<String> list)
	{

		if (vertices[indice].getPai() != -1)
		{
			list.add(vertices[indice].getNome());
			imprimeCaminho(vertices, vertices[indice].getPai(), list);
		}

	}

	public static void imprimirA(Vertice[] vertices, LinkedList<Integer> fila)
	{
		if (vertices != null)
		{
			while (!fila.isEmpty())
			{
				int last = fila.removeFirst();

				System.out.println(vertices[last].getNome());
				if (hasFather(vertices, 0, last))
				{
					// printPath(vertices, 0, last);

					printPath(vertices, 0, last);
					System.out.println("");

				}
			}

			// System.out.println(hasFather(vertices, 0, 4));

		}
	}

	public static boolean hasFather(Vertice vertices[], int pai, int destino)
	{
		if (vertices[destino].getPai() != -1)
		{
			if (vertices[destino].getPai() == pai)
				return true;
			else
				return hasFather(vertices, pai, vertices[destino].getPai());
		}
		else if (destino == pai)
			return true;

		return false;
	}

	public static void printPath(Vertice vertices[], int inicio, int destino)
	{
		if (inicio == destino)
			System.out.print(vertices[inicio].getNome() + " ");
		else if (vertices[destino].getPai() == -1)
			System.out.println("");
		else
		{
			printPath(vertices, inicio, vertices[destino].getPai());
			System.out.print(vertices[destino].getNome() + " ");
		}
	}

	public static int procurarIndicePeloNome(Vertice[] vertices, String nome)
	{
		int vertice1 = -1;

		for (int i = 0; i < vertices.length; i++)
		{
			if (vertices[i].getNome().equals(nome))
			{
				return i;
			}
		}

		return vertice1;
	}

	public static void imprimir(Vertice[] vertices)
	{
		for (int i = 0; i < vertices.length; i++)
		{
			if (vertices[i].getChave() == Double.MAX_VALUE)
			{
				System.out.print(vertices[0] + " " + vertices[i] + " "
						+ "inf\n");
			}
			else
			{
				if (vertices[i].getChave() % 1 == 0)
				{
					System.out.print(imprimirCaminho(vertices[i], vertices)
							+ " " + vertices[i].getChave() + "\n");
				}
				else
				{
					System.out.print(imprimirCaminho(vertices[i], vertices)
							+ " " + vertices[i].getChave() + "\n");
				}
			}
		}
	}

	public static String imprimirCaminho(Vertice u, Vertice[] vertices)
	{
		String caminho = "";
		Stack<String> pilha = new Stack<>();
		pilha.push(u.getNome());
		while (u.getPai() != -1)
		{
			pilha.push(vertices[u.getPai()].getNome() + " ");
			u = vertices[u.getPai()];
		}
		while (!pilha.isEmpty())
		{
			caminho = caminho + pilha.pop();
		}
		return caminho;
	}

	@SuppressWarnings({ "incomplete-switch", "unused" })
	public static void main(String[] args)
	{

		// Scanner in = new Scanner(System.in);

		Scanner in = null;
		try
		{
			in = new Scanner(new File("in.txt"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

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
				{
					estado = Estado.VERTICE;
				}
				if (estadoAnterior == Estado.VERTICE)
				{
					vertices = new Vertice[ListaVertices.size()];
					vertices = ListaVertices.toArray(vertices);
					estado = Estado.ARESTA;
				}

				continue;
			}
			else if (linha.equals("?"))
			{
				break;
			}

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
				double peso = Double.parseDouble(info[2]);
				if (peso % 1 == 0)
					peso = (int) peso;

				vertices[vertice1].getAdj().addLast(new Aresta(vertice2, peso));

				break;
			}
		}

		LinkedList<Integer> fila = dijkstra(vertices, 0);

		// imprimir(vertices, fila);

		if (vertices != null)
			imprimir(vertices);
	}
}
