package relogio;

public class Cliente
{

	public static void main(String[] args)
	{
		RelogioDigital rd = new RelogioDigital();
		RelogioAnalogico ra = new RelogioAnalogico();
		
		RelogioCentral relogio = RelogioCentral.getRelogio();
		relogio.addObservador(rd);
		relogio.addObservador(ra);
		
		relogio.alterarHora();
		System.out.println("Central: "+relogio.getHora());
		System.out.println("Digital: "+rd.getHora());
		System.out.println("Analógico: "+ra.getHora());
		
		relogio.alterarHora();
		System.out.println("\nCentral: "+relogio.getHora());
		System.out.println("Digital: "+rd.getHora());
		System.out.println("Analógico: "+ra.getHora());
		
		relogio.alterarHora();
		System.out.println("\nCentral: "+relogio.getHora());
		System.out.println("Digital: "+rd.getHora());
		System.out.println("Analógico: "+ra.getHora());
	}

}
