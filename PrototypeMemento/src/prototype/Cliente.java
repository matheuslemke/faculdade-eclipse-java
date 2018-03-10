package prototype;

public class Cliente
{

	public static void main(String[] args)
	{
		Forma r1 = new Retangulo(2, 4);
		Forma t1 = new Triangulo(3, 4);

		Forma r2 = r1.clonar();
		r2.setAltura(3);

		Forma t2 = t1.clonar();
		t2.setLargura(6);

		System.out.println("햞ea r1: " + r1.calculaArea());
		System.out.println("햞ea r2: " + r2.calculaArea());
		System.out.println("햞ea t1: " + t1.calculaArea());
		System.out.println("햞ea t2: " + t2.calculaArea());

	}

}
