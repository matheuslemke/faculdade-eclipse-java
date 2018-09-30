package floydwarshall;

public class Utils
{
	public Link[] toArray(Link[][] matrix)
	{
		Link[] array = new Link[((matrix.length * matrix.length) - matrix.length) / 2];

		int k = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (i > j)
				{
					array[k] = matrix[i][j];
					k++;
				}
			}
		}
		return array;
	}

	public int[] getRowColumn_Matrix(int position)
	{
		int row = 1, column = 0, count = 0;

		for (int j = 1; count < position; j++)
		{
			count += j;
			if (count <= position)
			{
				row++;
			} else
			{
				column = position - (count - j);
			}
		}
		return new int[]
		{ row, column };
	}

	public int getIndex_Array(int row, int column)
	{
		return (((row - 1) * row) / 2) + column;
	}

	public void showArrayAsMatrix(Link[] array)
	{
		int aux = 0, sum = 2;

		for (int i = 0; i < array.length; i++)
		{
			if (array[i].getW() < 100000000)
				System.out.print(array[i].getW() + " ");
			else
				System.out.print("∞ ");
			if (i == aux)
			{
				System.out.println();
				aux += sum;
				sum++;
			}
		}
		System.out.println();
	}

	public void showShortestPaths(Link[] array)
	{
		int[] positions;
		for (int i = 0; i < array.length; i++)
		{
			positions = getRowColumn_Matrix(i);

			System.out.print("Menor distância entre " + positions[0] + " e "
					+ positions[1] + " = ");
			System.out.println(array[i].getW());
			System.out.print("Menor caminho entre " + positions[0] + " e "
					+ positions[1] + " = [");
			for (int inter : array[i].getInterSource())
			{
				System.out.print(inter + " ");
			}
			System.out.print("]");
			System.out.println("\n");
		}
	}
}
