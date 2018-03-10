package mediator;

public class Cliente
{

	public static void main(String[] args)
	{
		ConcreteActor a1 = new ConcreteActor("José");
		ConcreteActor a2 = new ConcreteActor("João");
		ConcreteActor a3 = new ConcreteActor("Maria");

		Mediador m = new MediadorConcreto();
		m.addActor(a1.getName(), a1);
		m.addActor(a2.getName(), a2);
		m.addActor(a3.getName(), a3);

		a1.setMediador(m);
		a2.setMediador(m);
		a3.setMediador(m);
		
		a1.send("oi", "João");
		a2.send("olá amigo", "José");
		a3.send("também quero conversar!", "João");
		a3.send("também quero conversar!", "José");


		
	}
}
