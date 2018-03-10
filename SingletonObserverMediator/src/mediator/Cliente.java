package mediator;

public class Cliente
{

	public static void main(String[] args)
	{
		ConcreteActor a1 = new ConcreteActor("Jos�");
		ConcreteActor a2 = new ConcreteActor("Jo�o");
		ConcreteActor a3 = new ConcreteActor("Maria");

		Mediador m = new MediadorConcreto();
		m.addActor(a1.getName(), a1);
		m.addActor(a2.getName(), a2);
		m.addActor(a3.getName(), a3);

		a1.setMediador(m);
		a2.setMediador(m);
		a3.setMediador(m);
		
		a1.send("oi", "Jo�o");
		a2.send("ol� amigo", "Jos�");
		a3.send("tamb�m quero conversar!", "Jo�o");
		a3.send("tamb�m quero conversar!", "Jos�");


		
	}
}
