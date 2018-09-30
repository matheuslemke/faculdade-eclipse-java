package com.ag.vrp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LocalSearchOperators
{
	private Random random = new Random(System.currentTimeMillis());
	private int graphN;

	public LocalSearchOperators(int graphN)
	{
		this.graphN = graphN;
	}

	public int[] relocate(int[] solution)
	{
		int[][] routeInfo = findOneRoute(solution, null, null);
		int[] route = routeInfo[0];

		if (route.length == 1)
		{
			System.err.println("Rota com comprimento unitário!");
			return null;
		}

		int i = random.nextInt(route.length), j = random.nextInt(route.length);

		while (j == i)
			j = random.nextInt(route.length);

		// j sempre irá salvar o maior índice
		if (j < i)
		{
			int aux = i;
			i = j;
			j = aux;
		}
		int[] routeRet = new int[route.length];

		// Antes do i...
		for (int k = 0; k < i; k++)
			routeRet[k] = route[k];

		// Depois do i incluindo o j...
		for (int k = i; k < j; k++)
			routeRet[k] = route[k + 1];

		// Colocando o i
		routeRet[j] = route[i];

		// Depois do j...
		for (int k = j + 1; k < route.length; k++)
			routeRet[k] = route[k];
		System.out.println("");
		replaceSolution(solution, routeRet, routeInfo[1][0], routeInfo[1][1]);
		System.out.println("");
		return solution;
	}

	private int[] replaceSolution(int[] solution, int[] route, int indexStart, int indexEnd)
	{
		for (int i = indexStart + 1, j = 0; i < indexEnd; i++, j++)
			solution[i] = route[j];
		return solution;
	}

	/**
	 * Aplica o operador 2-opt*
	 * 
	 * @param solution
	 *            vetor solução, ou cromossomo
	 * @return solução modificada
	 */
	public int[] twoOptStar(int[] solution)
	{
		int[][][] twoRoutesInfo = findTwoRoutes(solution, true);

		int[][] firstRouteInfo = twoRoutesInfo[0];
		int[] firstRoute = firstRouteInfo[0];
		int firstRouteStart = firstRouteInfo[1][0], firstRouteEnd = firstRouteInfo[1][1];
		int[][] secondRouteInfo = twoRoutesInfo[1];
		int[] secondRoute = secondRouteInfo[0];
		int secondRouteStart = secondRouteInfo[1][0], secondRouteEnd = secondRouteInfo[1][1];

		if (firstRoute.length == 1 || secondRoute.length == 1)
		{
			System.err.println("Rota com comprimento unitário!");
			return null;
		}
		int i = random.nextInt(firstRoute.length), j = random.nextInt(secondRoute.length), i2, j2;
		i2 = i + 1;
		j2 = j + 1;

		// Para evitar ArrayIndexOutOfBounds
		if (i2 == firstRoute.length)
			i2 = 0;
		if (j2 == secondRoute.length)
			j2 = 0;

		// Troca
		int aux = firstRoute[i2];
		firstRoute[i2] = secondRoute[j2];
		secondRoute[j2] = aux;

		solution = replaceSolution(solution, firstRoute, firstRouteStart, firstRouteEnd);
		solution = replaceSolution(solution, secondRoute, secondRouteStart, secondRouteEnd);

		return solution;
	}

	/**
	 * Encontra os índices de início de rota na solução
	 * 
	 * @param solution
	 *            vetor solução, ou cromossomo
	 * @return vetor contendo os índices dos marcadores de início na solução
	 */
	private int[] getBeginningOfRoutes(int[] solution)
	{
		int[] beginningOfRoutes;
		ArrayList<Integer> listBeginningOfRoutes = new ArrayList<>();
		for (int i = solution.length - 1; i >= 0;)
			if (solution[i] >= graphN)
			{
				listBeginningOfRoutes.add(i);
				i--;
				// Se for outro marcador, pule até achar uma entrega
				while (i >= 0 && solution[i] >= graphN)
					i--;
			} else
				i--;
		Collections.reverse(listBeginningOfRoutes);
		beginningOfRoutes = new int[listBeginningOfRoutes.size() + 1];
		beginningOfRoutes[0] = -1;
		for (int i = 1; i < beginningOfRoutes.length; i++)
			beginningOfRoutes[i] = listBeginningOfRoutes.get(i - 1);

		return beginningOfRoutes;
	}

	/**
	 * Encontra os índices de fim de rota na solução
	 * 
	 * @param solution
	 *            vetor solução, ou cromossomo
	 * @return vetor contendo os índices dos marcadores de fim na solução
	 */
	private int[] getEndingOfRoutes(int[] solution)
	{
		int[] endingOfRoutes;
		ArrayList<Integer> listEndingOfRoutes = new ArrayList<>();

		for (int i = 0; i < solution.length;)
			if (solution[i] >= graphN)
			{
				listEndingOfRoutes.add(i);
				i++;
				// Se for um marcador, pule até achar uma entrega
				while (i < solution.length && solution[i] >= graphN)
					i++;
			} else
				i++;
		endingOfRoutes = new int[listEndingOfRoutes.size() + 1];
		endingOfRoutes[endingOfRoutes.length - 1] = solution.length;
		for (int i = 0; i < endingOfRoutes.length - 1; i++)
			endingOfRoutes[i] = listEndingOfRoutes.get(i);

		return endingOfRoutes;
	}

	/**
	 * Encontra uma rota no vetor
	 * 
	 * @param solution
	 *            vetor solução, ou cromossomo
	 * @param beginningOfRoutes
	 *            vetor com os marcadores de início de rota disponíveis. Se for
	 *            null, significa que todos os marcadores podem ser utilizados
	 * @param endingOfRoutes
	 *            vetor com os marcadores de fim de rota disponíveis. Se for
	 *            null, significa que todos os marcadores podem ser utilizados
	 * @return matriz com 4 linhas, onde a 0 contem a rota encontrada, a 1
	 *         contém respectivamente os marcadores de início e término de rota
	 *         na solução, a 2 contém o parâmetro beginningOfRoutes atualizado e
	 *         a 3 contém o parâmetro endingOfRoutes atualizado
	 */
	private int[][] findOneRoute(int[] solution, int[] beginningOfRoutes, int[] endingOfRoutes)
	{
		if (beginningOfRoutes == null || endingOfRoutes == null)
		{
			beginningOfRoutes = getBeginningOfRoutes(solution);
			endingOfRoutes = getEndingOfRoutes(solution);
		}

		int indexStart = random.nextInt(beginningOfRoutes.length);
		int indexStartOnSolution = beginningOfRoutes[indexStart];

		int indexEnding;
		for (indexEnding = 0; indexStartOnSolution >= endingOfRoutes[indexEnding]; indexEnding++)
			;
		int indexEndOnSolution = endingOfRoutes[indexEnding];

		// A rota está no intervalo [vetor[indexStart+1].. vetor[indexEnd-1]]
		int[] route = new int[indexEndOnSolution - indexStartOnSolution - 1];
		for (int i = indexStartOnSolution + 1, j = 0; i < indexEndOnSolution; i++, j++)
			route[j] = solution[i];

		// Remover dos vetores de marcadores os valores já utilizados
		beginningOfRoutes = updateVector(beginningOfRoutes, indexStart);
		endingOfRoutes = updateVector(endingOfRoutes, indexEnding);

		return new int[][] { route, { indexStartOnSolution, indexEndOnSolution }, beginningOfRoutes, endingOfRoutes };
	}

	/**
	 * Procedimento que reduz o vetor, removendo o índice
	 * 
	 * @param array
	 *            vetor a ser reduzido
	 * @param index
	 *            índice a ser removido
	 */
	private int[] updateVector(int[] array, int index)
	{
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++)
			if (i != index)
				list.add(array[i]);
		int[] ret = new int[list.size()];
		for (int i = 0; i < array.length - 1; i++)
			ret[i] = list.get(i);
		return ret;
	}

	/**
	 * Encontra duas rotas na solução
	 * 
	 * @param solution
	 *            vetor solução, ou cromossomo. Deve conter no mínimo duas rotas
	 * @param different
	 *            especifica se é necessário que as duas rotas sejam diferentes
	 * @return uma matriz tridimensional onde o primeiro plano (matriz[0])
	 *         contem a matriz bidimensional com as informações da primeira rota
	 *         e o segundo plano contém as informações da segunda rota
	 */
	private int[][][] findTwoRoutes(int[] solution, boolean different)
	{
		int[][] firstRouteInfo = findOneRoute(solution, null, null);
		int[][] secondRouteInfo;
		if (different)
		{
			int[] firstBeginningOfRoutes = firstRouteInfo[2], firstEndingOfRoutes = firstRouteInfo[3];
			secondRouteInfo = findOneRoute(solution, firstBeginningOfRoutes, firstEndingOfRoutes);
		} else
			secondRouteInfo = findOneRoute(solution, null, null);

		return new int[][][] { firstRouteInfo, secondRouteInfo };
	}

	// TODO: Dúvida: como duas rotas terão o mesmo consumidor? Estou gerando os
	// vetores errado? Vários operadores fazem utilização de rotas diferentes
	// com entregas repetidas: (2)splitToSingle, (8)shift*, etc
}
