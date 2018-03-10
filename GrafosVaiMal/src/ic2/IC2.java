/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic2;

/**
 *
 * @author toshi
 */
public class IC2
{

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args)
	{
		Grafo g = new Grafo();

		// Aresta(peso, vertice1, vertice2, alfa)
		g.addA(new Aresta(2, 1, 2, 0.6154));
		g.addA(new Aresta(6, 1, 3, 0.0579));
		g.addA(new Aresta(10, 1, 4, 0.0153));
		g.addA(new Aresta(7, 1, 5, 0.8381));
		g.addA(new Aresta(6, 1, 6, 0.1934));
		g.addA(new Aresta(5, 1, 7, 0.4966));
		g.addA(new Aresta(10, 1, 8, 0.7271));
		g.addA(new Aresta(9, 1, 9, 0.7948));
		g.addA(new Aresta(8, 1, 10, 0.1365));
		g.addA(new Aresta(7, 2, 3, 0.3529));
		g.addA(new Aresta(6, 2, 4, 0.7468));
		g.addA(new Aresta(7, 2, 5, 0.0196));
		g.addA(new Aresta(9, 2, 6, 0.6822));
		g.addA(new Aresta(6, 2, 7, 0.8998));
		g.addA(new Aresta(9, 2, 8, 0.3093));
		g.addA(new Aresta(8, 2, 9, 0.9568));
		g.addA(new Aresta(8, 2, 10, 0.0118));
		g.addA(new Aresta(10, 3, 4, 0.4451));
		g.addA(new Aresta(9, 3, 5, 0.6813));
		g.addA(new Aresta(7, 3, 6, 0.3028));
		g.addA(new Aresta(10, 3, 7, 0.8216));
		g.addA(new Aresta(8, 3, 8, 0.8385));
		g.addA(new Aresta(8, 3, 9, 0.5226));
		g.addA(new Aresta(6, 3, 10, 0.8939));
		g.addA(new Aresta(7, 4, 5, 0.3795));
		g.addA(new Aresta(9, 4, 6, 0.5417));
		g.addA(new Aresta(5, 4, 7, 0.6449));
		g.addA(new Aresta(6, 4, 8, 0.5681));
		g.addA(new Aresta(6, 4, 9, 0.8801));
		g.addA(new Aresta(8, 4, 10, 0.1991));
		g.addA(new Aresta(5, 5, 6, 0.1509));
		g.addA(new Aresta(6, 5, 7, 0.8180));
		g.addA(new Aresta(5, 5, 8, 0.3704));
		g.addA(new Aresta(9, 5, 9, 0.1730));
		g.addA(new Aresta(6, 5, 10, 0.2987));
		g.addA(new Aresta(10, 6, 7, 0.6602));
		g.addA(new Aresta(5, 6, 8, 0.7027));
		g.addA(new Aresta(6, 6, 9, 0.9797));
		g.addA(new Aresta(8, 6, 10, 0.6614));
		g.addA(new Aresta(6, 7, 8, 0.5466));
		g.addA(new Aresta(9, 7, 9, 0.2714));
		g.addA(new Aresta(8, 7, 10, 0.28844));
		g.addA(new Aresta(8, 8, 9, 0.2523));
		g.addA(new Aresta(8, 8, 10, 0.4692));
		g.addA(new Aresta(8, 9, 10, 0.0648));

		while (g.isConexo())
		{
			double a = g.menorAlfa();
			System.out.println("A:" + a);
			if (a < 0.01)
			{
				break;
			}

			System.out.println("Arestas: " + g.arestas);
			System.out.println("");

			System.out.println("Prim: " + g.prim().toString());
			System.out.println("Peso Total: " + g.pesoTotal());
			System.out.println("Menor Alfa: " + g.menorAlfa());
			System.out.println("Menor Aresta: " + g.menorAresta() + "\n");
		}
		System.out.println("Arestas: " + g.arestas);
		System.out.println("");
	}
}
