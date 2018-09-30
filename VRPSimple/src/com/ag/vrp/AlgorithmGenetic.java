package com.ag.vrp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.constants.Constants;
import com.constants.Graph;
import com.constants.Utils;

public class AlgorithmGenetic
{
	private List<int[]> population;
	private int nPopulation;
	private double[] fitnessPathCost;
	private int[] nRoutes;
	private Random random = new Random(System.currentTimeMillis());
	private Graph graph;
	private LocalSearchOperators lso;

	public AlgorithmGenetic(int nPopulation, Graph graph)
	{
		this.nPopulation = nPopulation;
		this.graph = graph;
		this.lso = new LocalSearchOperators(graph.getN());
	}

	public double[] getFitnessPathCost()
	{
		return fitnessPathCost;
	}

	public List<int[]> run(int nGenerations, int crossRate, int mutationRate, int localSearchRate)
	{

		initializePopulation();
		fitnessPathCost();

		for (int g = 0; g < nGenerations; g++)
		{
			orderCrossOver(crossRate);
			swapMutation(mutationRate);
			select();
			countNumberRoutes();
			localSerchOperators(localSearchRate);
		}
		return population;
	}

	private void initializePopulation()
	{
		this.population = new ArrayList<>(nPopulation);
		int nextIndex;

		for (int i = 0; i < nPopulation; i++)
		{
			int[] newchromosome = new int[this.graph.getN() + Constants.maxRoutes - 2];
			boolean[] visitedIndexes = new boolean[graph.getN() + Constants.maxRoutes - 2];
			for (int j = 1; j <= newchromosome.length; j++)
			{
				do
					nextIndex = random.nextInt(newchromosome.length);
				while (visitedIndexes[nextIndex]);
				visitedIndexes[nextIndex] = true;
				newchromosome[nextIndex] = j;
			}
			population.add(newchromosome);
		}
	}

	private void countNumberRoutes()
	{
		nRoutes = new int[population.size()];
		int n, chromosome[];
		boolean in_a_route;
		for (int i = 0; i < population.size(); i++)
		{
			chromosome = population.get(i);
			n = 0;
			in_a_route = false;
			for (int j = 0; j < chromosome.length; j++)
				if (chromosome[j] < graph.getN())
					in_a_route = true;
				else if (in_a_route)
				{
					n++;
					in_a_route = false;
				}
			if (chromosome[chromosome.length - 1] < this.graph.getN())
				n++;
			this.nRoutes[i] = n;
		}
	}

	private void fitnessPathCost()
	{
		this.fitnessPathCost = new double[population.size()];
		for (int i = 0; i < population.size(); i++)
		{
			fitnessPathCost[i] = fitnessPathCost(this.population.get(i));
		}
	}

	private double fitnessPathCost(int[] chromo)
	{
		double fitness;
		// Se o primeiro valor do cromossomo for válido, somar no fitness o
		// valor da aresta, senão, zerar
		fitness = chromo[0] < this.graph.getN() ? this.graph.getEdge(0, chromo[0]) : 0;
		// Loop para percorrer o cromossomo e somar os valores de cada
		// aresta ao fitness
		for (int j = 1; j < chromo.length; j++)
			if (chromo[j - 1] < this.graph.getN())
				if (chromo[j] >= this.graph.getN())
					fitness += this.graph.getEdge(chromo[j - 1], 0);
				else
					fitness += this.graph.getEdge(chromo[j - 1], chromo[j]);
			else if (chromo[j] < this.graph.getN())
				fitness += this.graph.getEdge(0, chromo[j]);
		if (chromo[chromo.length - 1] < this.graph.getN())
			fitness += this.graph.getEdge(chromo[chromo.length - 1], 0);
		return fitness;
	}

	private void orderCrossOver(int crossRate)
	{
		int nChildren = (nPopulation * crossRate) / 100, index1, index2, indexDad, indexMom;
		int[] dad, mom, babyDad, babyMom;
		Utils util = new Utils();
		for (int c = 0; c < (nChildren / 2); c++)
		{
			indexDad = random.nextInt(population.size());
			indexMom = random.nextInt(population.size());

			dad = population.get(indexDad);
			mom = population.get(indexMom);

			babyDad = util.initializeBaby(dad.length);
			babyMom = util.initializeBaby(dad.length);

			index1 = random.nextInt(dad.length);
			index2 = random.nextInt((dad.length - index1)) + index1;

			fillOffspring(babyDad, dad, mom, index1, index2);
			fillOffspring(babyMom, mom, dad, index1, index2);

			replacePopulation(babyDad, indexDad, indexMom);
			replacePopulation(babyMom, indexDad, indexMom);
		}
	}

	private void fillOffspring(int[] baby, int[] parent1, int[] parent2, int indexCutOne, int indexCutTwo)
	{
		// Vetor para verificar a visitação das cidades
		boolean[] visitedBaby = new boolean[parent1.length + 1];
		int nVisited = 0;
		for (int i = indexCutOne; i < indexCutTwo; i++)
		{
			baby[i] = parent1[i];
			visitedBaby[baby[i]] = true;
			nVisited++;
		}
		for (int i = indexCutTwo, j = indexCutTwo; nVisited < visitedBaby.length - 1; i++)
		{
			if (i < parent1.length)
			{
				if (!visitedBaby[parent2[i]])
				{
					visitedBaby[parent2[i]] = true;
					baby[j] = parent2[i];
					nVisited++;
					j++;
					if (j == parent1.length)
						j = 0;
					if (j == indexCutOne)
						j = indexCutTwo;
				}
			} else
				i = -1;
		}
	}

	// Seleciona um cromossomo e troca um atributo de posição
	private void swapMutation(int mutationRate)
	{
		int nChildren = (nPopulation * mutationRate) / 100, baby[], aux, indexDad, indexMom;
		for (int i = 0; i < nChildren; i++)
		{
			baby = population.get(random.nextInt(population.size())).clone();
			indexDad = random.nextInt(baby.length);
			indexMom = indexDad;
			while (indexDad == indexMom)
				indexMom = random.nextInt(baby.length);
			aux = baby[indexDad];
			baby[indexDad] = baby[indexMom];
			baby[indexMom] = aux;
			replacePopulation(baby, indexDad, indexMom);
		}
	}

	private void replacePopulation(int[] baby, int indexDad, int indexMom)
	{
		int worstIndex;
		double fitnessBaby = fitnessPathCost(baby), fitnessDad = this.fitnessPathCost[indexDad],
				fitnessMom = this.fitnessPathCost[indexMom];
		if (fitnessDad >= fitnessMom)
			worstIndex = indexDad;
		else
			worstIndex = indexMom;
		if (this.fitnessPathCost[worstIndex] > fitnessBaby)
		{
			this.population.set(worstIndex, baby);
			this.fitnessPathCost[worstIndex] = fitnessBaby;
		}
	}

	private void replacePopulation(int[] baby, int indexDad)
	{
		double fitnessBaby = fitnessPathCost(baby);
		if (this.fitnessPathCost[indexDad] > fitnessBaby)
		{
			this.population.set(indexDad, baby);
			this.fitnessPathCost[indexDad] = fitnessBaby;
		}
	}

	private void select()
	{
		sortFitness(this.fitnessPathCost, 0, fitnessPathCost.length - 1);
	}

	private int partition(double array[], int left, int right)
	{
		int i = left, j = right;
		int[] tmpArray;
		double tmpValue;
		double pivot = array[(left + right) / 2];

		while (i <= j)
		{
			while (array[i] < pivot)
				i++;
			while (array[j] > pivot)
				j--;
			if (i <= j)
			{
				tmpValue = array[i];
				array[i] = array[j];
				array[j] = tmpValue;
				tmpArray = this.population.get(i);
				this.population.set(i, this.population.get(j));
				this.population.set(j, tmpArray);
				i++;
				j--;
			}
		}
		return i;
	}

	// Quick Sort
	private void sortFitness(double array[], int left, int right)
	{
		int index = partition(array, left, right);
		if (left < index - 1)
			sortFitness(array, left, index - 1);
		if (index < right)
			sortFitness(array, index, right);
	}

	private void localSerchOperators(int localSearchRate)
	{
		int nChildren = (nPopulation * localSearchRate) / 100;
		for (int c = 0; c < nChildren; c++)
		{
			relocate();
			twoOptStar();
		}
	}

	private void relocate()
	{
		int index = random.nextInt(nPopulation);
		replacePopulation(lso.relocate(population.get(index).clone()), index);
	}

	private void twoOptStar()
	{
		int index = random.nextInt(nPopulation);
		while (nRoutes[index] < 2)
			index = random.nextInt(nPopulation);
		replacePopulation(lso.twoOptStar(population.get(index).clone()), index);
	}
}
