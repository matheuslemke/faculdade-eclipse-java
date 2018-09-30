package com.ag.vrp;

import java.util.List;
import com.constants.UndirectedGraph;
import com.constants.Utils;

public class Main
{
	public static void main(String[] args)
	{
		// O N inclui o número de entregas + o depósito
		UndirectedGraph graph = new UndirectedGraph(5);
		graph.addEdge(1, 0, 3);
		graph.addEdge(2, 0, 4);
		graph.addEdge(2, 1, 4);
		graph.addEdge(3, 0, 2);
		graph.addEdge(3, 1, 6);
		graph.addEdge(3, 2, 5);
		graph.addEdge(4, 0, 7);
		graph.addEdge(4, 1, 3);
		graph.addEdge(4, 2, 8);
		graph.addEdge(4, 3, 6);

		// AlgorithmGenetic ag = new AlgorithmGenetic(40, graph);

		// List<int[]> result = ag.run(50, 50, 10, 10);

		LocalSearchOperators lso = new LocalSearchOperators(5);
		int[] solution = { 1, 2, 5, 6, 3, 4 };

		// lso.relocate(solution);

		// int[][] firstRouteInfo = lso.findOneRoute(solution, null, null);
		// int[] firstRoute = firstRouteInfo[0];
		// int firstRouteStart = firstRouteInfo[1][0], firstRouteEnd =
		// firstRouteInfo[1][1];
		// int[] firstBeginningOfRoutes = firstRouteInfo[2], firstEndingOfRoutes
		// = firstRouteInfo[3];
		//
		// int[][] secondRouteInfo = lso.findOneRoute(solution,
		// firstBeginningOfRoutes, firstEndingOfRoutes);
		// int[] secondRoute = secondRouteInfo[0];
		// int secondRouteStart = secondRouteInfo[1][0], secondRouteEnd =
		// secondRouteInfo[1][1];
		// int[] secondBeginningOfRoutes = secondRouteInfo[2],
		// secondEndingOfRoutes = secondRouteInfo[3];

		// System.out.println(".");

		// double[] fit = ag.getFitnessPathCost();
		//
		// for (int i = 0; i < result.size(); i++)
		// {
		// int[] chromo = result.get(i);
		// for (int j = 0; j < chromo.length; j++)
		// {
		// System.out.print(chromo[j] + " ");
		// }
		// System.out.print(" " + fit[i]);
		// System.out.println();
		// }

		// Utils utils = new Utils();
		// int[] s = { 1, 2, 5, 3, 6, 4 };
		// int[][] routeInfo = utils.findRoute(s, 5);
		// int[] route = routeInfo[0];
		// for (int i = 0; i < route.length; i++)
		// {
		// System.out.print(route[i] + " ");
		// }
		// System.out.println();
		// System.out.println(routeInfo[1][0]);
		// System.out.println(routeInfo[1][1]);
	}
}
