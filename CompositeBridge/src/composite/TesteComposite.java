package composite;

public class TesteComposite
{

	public static void main(String[] args)
	{
		Congresso c1 = new Congresso();
		Individuo p1 = new Individuo();
		Individuo p2 = new Individuo();
		Individuo p3 = new Individuo();
		Individuo p4 = new Individuo();
		Individuo p5 = new Individuo();
		Individuo p6 = new Individuo();
		Individuo p7 = new Individuo();
		Individuo p8 = new Individuo();
		Individuo p9 = new Individuo();
		Individuo p10 = new Individuo();
		Instituicao p11 = new Instituicao();
		Instituicao p12 = new Instituicao();

		p12.add(p1);
		p12.add(p2);
		p12.add(p3);

		p11.add(p4);
		p11.add(p5);
		p11.add(p6);
		p11.add(p7);
		p11.add(p12);

		c1.add(p11);
		c1.add(p8);
		c1.add(p9);
		c1.add(p10);

		System.out.println("Participantes: " + c1.totalParticipantes());
		System.out.println("Assentos: " + c1.totalAssentos());

	}

}
