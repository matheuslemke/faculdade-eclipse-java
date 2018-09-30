package floydwarshall;

public class Main
{

	public static void main(String[] args)
	{
		Constants constants = new Constants();
		Utils utils = new Utils();
		FloydWarshall algorithm = new FloydWarshall();

		Link[] array = utils.toArray(constants.matrix);

		algorithm.findShortestPaths(array, constants.matrix.length);

		utils.showArrayAsMatrix(array);
		
		utils.showShortestPaths(array);
	}
}
