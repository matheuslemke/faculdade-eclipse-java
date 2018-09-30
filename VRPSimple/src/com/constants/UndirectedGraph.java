package com.constants;

//CONSIDERAR O VÉRTICE 0 COMO SENDO O DEPÓSITO
public class UndirectedGraph implements Graph
{
	private double[] edges;
	private int n;

	public UndirectedGraph(int n)
	{
		this.n = n;
		int nEdges = new Double((Math.pow(n, 2) - n) / 2).intValue();
		this.edges = new double[nEdges];
		initializeEdges();
	}

	public void initializeEdges()
	{
		for (int i = 0; i < this.edges.length; i++)
			this.edges[i] = Double.POSITIVE_INFINITY;
	}

	// Matriz triangular inferior
	// Vertex1 é a linha e Vertex2 é a coluna
	public void addEdge(int vertex1, int vertex2, double w)
	{
		if (vertex2 > vertex1)
		{
			int aux = vertex2;
			vertex2 = vertex1;
			vertex1 = aux;
		}
		// System.out.println("Adding the edge " + vertex1 + ", " + vertex2);
		if ((0 < vertex1 && vertex1 < n) && (0 <= vertex2 && vertex2 < vertex1))
		{
			int index = (((vertex1 - 1) * vertex1) / 2) + vertex2;
			// System.out.println("Index = " + index);
			this.edges[index] = w;
		} else
			System.err.println("Out of bounds - ADD");
	}

	public double getEdge(int vertex1, int vertex2)
	{
		double w = Double.POSITIVE_INFINITY;
		if (vertex2 > vertex1)
		{
			int aux = vertex2;
			vertex2 = vertex1;
			vertex1 = aux;
		}
		if ((0 < vertex1 && vertex1 < n) && (0 <= vertex2 && vertex2 < vertex1))
		{
			int index = (((vertex1 - 1) * vertex1) / 2) + vertex2;
			w = this.edges[index];
		} else
			System.err.println("Out of bounds - GET\n" + vertex1 + " " + vertex2 + "\n");
		return w;
	}

	public int getN()
	{
		return n;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Vertices: ");
		sb.append(this.n);
		sb.append("\n");
		sb.append("Edges: ");
		sb.append(this.edges.length);
		sb.append("\n");
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				sb.append(i + " ");
				sb.append(j);
				sb.append(" = ");
				sb.append(getEdge(i, j));
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
