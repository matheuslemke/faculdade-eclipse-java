import no.uib.cipr.matrix.NotConvergedException;

public class Main
{

	/**
	 * @param args
	 * @throws NotConvergedException
	 */
	public static void main(String[] args) throws NotConvergedException
	{

//		 Elm ds = new Elm(0, 20, "sig");
//		 ds.train("sinc_train");
//		 ds.test("sinc_test");

		
		Elm ds = new Elm(1, 20, "sig");
		ds.train("diabetes_train");
		//ds.test("diabetes_test");
		double[] inpt = {0, 0.41176500, 0.80000000, 0.44262300, 0.32000000, 0.20685600, 0.45454500, 0.21776300, 0.30000000};
		double[] out = ds.testOut(inpt);
		/*
        if (tip = 1)
        	String classes = {"sem diabete", "com diabetes"};
           print(classes[(int)out[0]]) //desnormalizar
         else
        	   print(out[0])
           /*
		 * Elm ds = new elm(1, 20, "sig"); ds.train("segment_train");
		 * ds.test("segment_test");
		 */

		System.out.println("TrainingTime:" + ds.getTrainingTime());
		System.out.println("TrainingAcc:" + ds.getTrainingAccuracy());
		System.out.println("TestingTime:" + ds.getTestingTime());
		System.out.println("TestAcc:" + ds.getTestingAccuracy());

	}

}