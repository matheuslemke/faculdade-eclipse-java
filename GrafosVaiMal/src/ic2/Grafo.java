/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshi
 */
public class Grafo
{

	public static List<Aresta> arestas = new ArrayList<>();
	private static List<Aresta> coArestas = new ArrayList<>();
	public static List<Aresta> auxPrim = new ArrayList<>();

	private Aresta a;

	public Grafo()
	{

	}

	/**
	 * @return the arestas
	 */
	public List<Aresta> getArestas()
	{
		return arestas;
	}

	/**
	 * @param arestas
	 *            the arestas to set
	 */
	public void setArestas(List<Aresta> arestas)
	{
		this.arestas = arestas;
	}

	/**
	 * @return the coArestas
	 */
	public static List<Aresta> getCoArestas()
	{
		return coArestas;
	}

	public void addA(Aresta a)
	{
		arestas.add(a);
	}

	public void dropA(Aresta a)
	{
		arestas.remove(a);
	}

	public Aresta getA()
	{
		return a;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(Aresta a)
	{
		this.a = a;
	}

	public List<Aresta> prim()
	{
		List<Object> T = new ArrayList<>();
		List<Object> V = new ArrayList<>();
		List<Aresta> S = new ArrayList<>();
		List<Object> N = new ArrayList<>();

		dropVertice(V);
		dropVertice(N);

		// while (!V.isEmpty()) {
		while (!T.containsAll(N))
		{
			S.add(iteracao(T, V));
		}
		auxPrim = S;
		return S;
	}

	public Aresta iteracao(List<Object> T, List<Object> V)
	{
		Aresta a = new Aresta();

		if (T.isEmpty())
		{
			T.add(V.remove(0));
		}

		a = menor(V, T);
		if (!T.contains(a.getVertice1()))
		{
			T.add(a.getVertice1());
			V.remove((Object) a.getVertice1());
		}
		else
		{
			T.add(a.getVertice2());
			V.remove((Object) a.getVertice2());
		}
		return a;
	}

	// Função que adiciona na lista (V) todas as arestas
	private void dropVertice(List<Object> V)
	{
		for (Aresta aresta : arestas)
		{
			if (!V.contains(aresta.getVertice1()))
			{
				V.add(aresta.getVertice1());
				if (!V.contains(aresta.getVertice2()))
				{
					V.add(aresta.getVertice2());
				}
			}
			else
			{
				if (!V.contains(aresta.getVertice2()))
				{
					V.add(aresta.getVertice2());
				}
			}
		}
	}

	// Menor aresta em relação a todas as arestas
	private Aresta menor(List<Object> V, List<Object> T)
	{
		Aresta menor = new Aresta();
		boolean aux = true;

		for (Aresta aresta : arestas)
		{
			if (((T.contains(aresta.getVertice1())) && (V.contains(aresta
					.getVertice2())))
					|| ((T.contains(aresta.getVertice2())) && (V
							.contains(aresta.getVertice1()))))
			{

				if (aux)
				{
					menor = aresta;
					aux = false;
				}
				else
				{
					if (menor.getPeso() > aresta.getPeso())
					{
						menor = aresta;
					}
				}
			}
		}
		return menor;
	}

	// Peso Final, somas dos pesos das arestas do prim
	public double pesoTotal()
	{
		List<Aresta> S = auxPrim;
		double aux = 0;

		for (Aresta aresta : S)
		{
			if (!arestas.contains(S))
			{
				aux += aresta.getPeso();
			}
		}
		return aux;
	}

	// Menor alfa das arestas do prim
	public double menorAlfa()
	{
		List<Aresta> S = auxPrim;
		double menor = 2;
		for (Aresta aresta : S)
		{
			if (!arestas.contains(S))
			{
				if (menor > aresta.getAlfa())
				{
					menor = aresta.getAlfa();
				}
			}
		}
		return menor;
	}

	// Menor aresta em relação ao alfa
	public Aresta menorAresta()
	{
		List<Aresta> S = auxPrim;
		double menor = 2;
		Aresta aux = null;

		for (Aresta aresta : S)
		{
			if (menor > aresta.getAlfa())
			{
				menor = aresta.getAlfa();
				aux = aresta;
			}
		}
		removeArestaMenores(aux);
		return aux;
	}

	/* Remove Arestas não correspondidas q seja menor que a menor aresta */
	public void removeArestaMenores(Aresta A)
	{
		List<Aresta> aux = new ArrayList<>();

		if (!arestas.isEmpty())
		{
			for (Aresta a : arestas)
			{
				if (a.getAlfa() <= A.getAlfa())
				{
					aux.add(a);
				}
			}
			for (Aresta a : aux)
			{
				arestas.remove(a);
			}
		}
	}

	public List<Aresta> listaMenorAresta()
	{

		coArestas.add(menorAresta());

		return coArestas;
	}

	public List<Aresta> direcionar()
	{
		List<Aresta> S = arestas;
		List<Aresta> K = new ArrayList<>();

		if (K.isEmpty())
		{
			for (Aresta s : S)
			{
				K.add(s);
				K.add(new Aresta(s.getPeso(), s.getVertice2(), s.getVertice1(),
						s.getAlfa()));
			}
			return K;
		}
		return null;
	}

	/* Remove aresta em comum */
	public List<Aresta> removerLxL(List<Aresta> l1, List<Aresta> l2)
	{

		for (Aresta l : l1)
		{
			if (l2.contains(l))
			{
				l2.remove(l);
			}
		}

		return l2;
	}

	/*
	 * Adiciona aresta do l1 que não pertence no l2 Remove as que pertence no S
	 * e ordena a lista S em relação ao objeto
	 */
	public List<Aresta> atualiza(List<Aresta> l1, List<Aresta> l2,
			List<Aresta> S, Object o, Object a)
	{

		if (!S.isEmpty())
		{
			for (Aresta l : l1)
			{
				if (!l2.contains(l))
				{
					l2.add(l);
				}
			}
			S = ordenar(S, o, a);
			removeArestaContida(l1, S);
			removeArestaContida(l2, S);
		}
		return l2;
	}

	public boolean isConexo()
	{
		List<Aresta> S = direcionar();
		List<Aresta> K = new ArrayList<>();
		List<Aresta> kAux = new ArrayList<>();
		Aresta aux = new Aresta();
		Object o = new Object();
		Object a = new Object();
		int cont = 0;

		if (K.isEmpty())
		{
			aux = S.remove(0);
			K.add(aux);
		}

		o = aux.getVertice2();

		/* Enquanto existir algum vertice em K que pertence à S */
		while (bbb(S, K))
		{

			for (Aresta k : K)
			{
				if (k.getVertice2().equals(o))
				{
					for (Aresta s : S)
					{
						if (isVertice1IqualsO(S, o))
						{
							if (k.getVertice2().equals(s.getVertice1()))
							{
								kAux.add(s);
								o = s.getVertice2();
								a = s.getVertice1();
								break;
							}
						}
						else
						{
							if ((!s.getVertice2().equals(o))
									&& (!s.getVertice1().equals(a)))
							{
								if (isContido(S, kAux) == true)
								{
									o = arestaContida(S, kAux);
								}
							}
						}
					}
					removerLxL(kAux, S);
				}
				else if ((!isObjetoContido(K, o)) && (!isObjetoContido(S, o)))
				{
					o = aaa(S, K, o);
				}
			}
			atualiza(kAux, K, S, o, a);

			if (S.isEmpty())
			{
				return true;
			}
		}
		return false;
	}

	public Object aaa(List<Aresta> A, List<Aresta> B, Object o)
	{

		for (Aresta b : B)
		{
			if (isVerticeContido(A, b))
			{
				o = verticeContido(A, b);
				break;
			}
		}
		return o;
	}

	public boolean bbb(List<Aresta> A, List<Aresta> B)
	{

		for (Aresta b : B)
		{
			if (isVerticeContido(A, b))
			{
				return true;
			}
		}
		return false;
	}

	/*
	 * Remove as arestas pertencentes a List<Aresta> S que possui algum dos
	 * vertices contido na List<Aresta> aux
	 */
	public void removeArestaContida(List<Aresta> S, List<Aresta> aux)
	{
		List<Aresta> x = new ArrayList<>();
		boolean a = true;

		if (!S.isEmpty())
		{
			for (Aresta s : S)
			{
				if (isVerticeContido(aux, s))
				{
					a = false;
				}
				else
				{
					a = true;
					x.add(s);
				}
			}
			removerLxL(x, S);
		}
	}

	/*
	 * Verifica se a List<Aresta> S contém uma alguma aresta pertencente a
	 * List<Aresta> aux
	 */
	public boolean isContido(List<Aresta> S, List<Aresta> aux)
	{
		Object x = new Object();

		if (!S.isEmpty())
		{
			for (Aresta aux1 : aux)
			{
				for (Aresta s : S)
				{
					if (s.getVertice2().equals(aux1.getVertice1()))
					{
						x = s.getVertice2();
						return true;
					}
					else if (s.getVertice2().equals(aux1.getVertice2()))
					{
						x = s.getVertice2();
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * Retorna uma aresta pertencente a List<Aresta> S que possui algum dos
	 * vertices contido na List<Aresta> aux
	 */
	public Object arestaContida(List<Aresta> S, List<Aresta> aux)
	{
		Object x = new Object();

		if (!S.isEmpty())
		{
			for (Aresta aux1 : aux)
			{
				for (Aresta s : S)
				{
					if (s.getVertice2().equals(aux1.getVertice1())
							&& s.getVertice2().equals(aux1.getVertice2()))
					{
						x = aux1.getVertice2();
					}
					else if (s.getVertice2().equals(aux1.getVertice1()))
					{
						x = s.getVertice2();
						return x;
					}
					else if (s.getVertice2().equals(aux1.getVertice2()))
					{
						x = s.getVertice2();
						return x;
					}
				}
			}
		}
		return x;
	}

	public void contemVertice(Object o, List<Aresta> S)
	{
		List<Aresta> aux = new ArrayList<>();

		for (Aresta s : S)
		{
			if (s.getVertice1().equals(o))
			{
				aux.add(s);
			}
		}
		removerLxL(aux, S);
	}

	/* Ordena em função do objeto a ser o primeiro */
	public List<Aresta> ordenar(List<Aresta> S, Object o, Object a)
	{
		List<Aresta> b = new ArrayList<>();

		if (S.get(0).getVertice1() == o)
		{
			return S;
		}

		for (Aresta s : S)
		{
			if (s.getVertice1() == o)
			{
				b.add(s);
			}
			else if (s.getVertice2() == a)
			{
				b.add(s);
			}
		}
		addArestaEmComum(S, b);

		return b;
	}

	public void addArestaEmComum(List<Aresta> l1, List<Aresta> l2)
	{

		for (Aresta l : l1)
		{
			if (!l2.contains(l))
			{
				l2.add(l);
			}
		}
	}

	/* Verifica se algum vertice da aresta está contido na lista */
	public boolean isVerticeContido(List<Aresta> A, Aresta x)
	{

		for (Aresta a : A)
		{
			if (a.getVertice1().equals(x.getVertice1()))
			{
				return true;
			}
			else if (a.getVertice1().equals(x.getVertice2()))
			{
				return true;
			}
			else if (a.getVertice2().equals(x.getVertice1()))
			{
				return true;
			}
			else if (a.getVertice2().equals(x.getVertice2()))
			{
				return true;
			}
		}
		return false;
	}

	public Object verticeContido(List<Aresta> A, Aresta x)
	{

		for (Aresta a : A)
		{
			if (a.getVertice1().equals(x.getVertice1()))
			{
				return a.getVertice1();
			}
			else if (a.getVertice1().equals(x.getVertice2()))
			{
				return a.getVertice1();
			}
			else if (a.getVertice2().equals(x.getVertice1()))
			{
				return a.getVertice2();
			}
			else if (a.getVertice2().equals(x.getVertice2()))
			{
				return a.getVertice2();
			}
		}
		return null;
	}

	public boolean isVertice1IqualsO(List<Aresta> A, Object x)
	{

		for (Aresta a : A)
		{
			if (a.getVertice1().equals(x))
			{
				return true;
			}
		}
		return false;
	}

	public boolean isObjetoContido(List<Aresta> A, Object o)
	{

		for (Aresta a : A)
		{
			if (a.getVertice1().equals(o))
			{
				return true;
			}
			else if (a.getVertice1().equals(o))
			{
				return true;
			}
			else if (a.getVertice2().equals(o))
			{
				return true;
			}
			else if (a.getVertice2().equals(o))
			{
				return true;
			}
		}
		return false;
	}
}
