package com.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils
{
	public Utils()
	{
	}

	public void showPopulation(List<int[]> population)
	{
		for (int[] chromosome : population)
		{
			showchromosome(chromosome, "Chromo");
		}
	}

	public void showchromosome(int[] chromosome, String name)
	{
		System.out.print(name + " [");
		for (int i = 0; i < chromosome.length; i++)
		{
			System.out.print(chromosome[i]);
			if (i + 1 == chromosome.length)
				System.out.println("]\n");
			else
				System.out.print(", ");
		}
	}

	public void showBooleanArray(boolean[] booleanArray, String type)
	{
		System.out.println(type + " Array");
		for (int i = 0; i < booleanArray.length; i++)
		{
			System.out.print(booleanArray[i] + " ");
		}
		System.out.println();
	}

	public int[] initializeBaby(int n)
	{
		int[] baby = new int[n];
		for (int i = 0; i < baby.length; i++)
			baby[i] = -1;
		return baby;
	}

	public List<int[]> orderCrossOverTest(int[] dad, int[] mom)
	{
		int[] babyDad = initializeBaby(dad.length), babyMom = initializeBaby(dad.length);
		List<int[]> babies = new ArrayList<>(2);
		int indexCutOne = -1, indexCutTwo = -1;
		Random random = new Random(System.currentTimeMillis());

		while (indexCutOne == indexCutTwo)
		{
			indexCutOne = random.nextInt(dad.length);
			indexCutTwo = random.nextInt(dad.length);
		}
		if (indexCutOne > indexCutTwo)
		{
			int aux = indexCutOne;
			indexCutOne = indexCutTwo;
			indexCutTwo = aux;
		}
		fillOffspring(babyDad, dad, mom, indexCutOne, indexCutTwo);
		fillOffspring(babyMom, mom, dad, indexCutOne, indexCutTwo);
		babies.add(babyDad);
		babies.add(babyMom);
		return babies;
	}

	private void fillOffspring(int[] baby, int[] parent1, int[] parent2, int indexCutOne, int indexCutTwo)
	{
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
}
