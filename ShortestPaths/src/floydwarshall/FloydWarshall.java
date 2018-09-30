package floydwarshall;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall
{
	public void findShortestPaths(Link[] array, int n) // n == matriz.lenght
	{
		Utils utils = new Utils();
		Link current, interOne, interTwo;
		int currentIndex, intermediateIndex_One, intermediateIndex_Two;
		boolean troca;
		for (int k = 1; k < n - 1; k++)
		{
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < i; j++)
				{
					if (Constants.debug)
						System.out.println("\nTestando para\ni = " + i
								+ "\nj = " + j + "\nk = " + k);

					troca = false;
					currentIndex = utils.getIndex_Array(i, j);
					intermediateIndex_One = utils.getIndex_Array(i, k);
					if (j > k)
						intermediateIndex_Two = utils.getIndex_Array(j, k);
					else
					{
						intermediateIndex_Two = utils.getIndex_Array(k, j);
						troca = true;
					}

					current = array[currentIndex];
					interOne = array[intermediateIndex_One];
					interTwo = array[intermediateIndex_Two];

					if (current.getW() > (interOne.getW() + interTwo.getW()))
					{
						current.setW(interOne.getW() + interTwo.getW());

						if (Constants.debug2)
							System.out.println("Old: "
									+ current.getInterSource().toString());

						defineIntermediates(array, troca, current, interOne,
								interTwo, currentIndex);

						if (Constants.debug2)
							System.out.println("New: "
									+ current.getInterSource().toString());
					}
					if (Constants.debug)
						System.out.println("Antigo valor: "
								+ array[currentIndex].getW());
					if (Constants.debug)
						System.out.println("Novo valor: "
								+ array[currentIndex].getW());
				}
			}
		}
	}

	private void defineIntermediates(Link[] array, boolean troca, Link current,
			Link interOne, Link interTwo, int currentIndex)
	{
		List<Integer> listSource = new ArrayList<>();
		List<Integer> listTarget = new ArrayList<>();

		if (troca)
		{
			insertDistincts(interOne.getInterSource(), listSource);
			insertDistincts(interTwo.getInterTarget(), listSource);

			insertDistincts(interTwo.getInterSource(), listTarget);
			insertDistincts(interOne.getInterTarget(), listTarget);
		} else
		{
			insertDistincts(interOne.getInterSource(), listSource);
			insertDistincts(interTwo.getInterSource(), listSource);

			insertDistincts(interTwo.getInterTarget(), listTarget);
			insertDistincts(interOne.getInterTarget(), listTarget);
		}
		current.setInterSource(listSource);

		current.setInterTarget(listTarget);
	}

	private void insertDistincts(List<Integer> from, List<Integer> to)
	{
		for (Integer inter : from)
		{
			if (!to.contains(inter))
				to.add(inter);
		}
	}
}
