package templatemethod;

import java.util.Arrays;

public class Cliente
{

	public static void main(String[] args)
	{
		Predio predios[] = new Predio[10];
		predios[0] = new Predio(22);
		predios[1] = new Predio(42);
		predios[2] = new Predio(13);
		predios[3] = new Predio(43);
		predios[4] = new Predio(25);
		predios[5] = new Predio(12);
		predios[6] = new Predio(56);
		predios[7] = new Predio(41);
		predios[8] = new Predio(22);
		predios[9] = new Predio(35);
		
		Arrays.sort(predios, new ComparaPredio());
		
		for (int i = 0; i < predios.length; i++)
		{
			System.out.println(predios[i].getAltura());
		}

	}

}
