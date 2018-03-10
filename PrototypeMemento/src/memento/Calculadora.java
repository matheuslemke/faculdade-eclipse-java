package memento;

import java.util.Stack;

public class Calculadora
{
	Stack<Memento> operacoesSalvas = new Stack<>();
	private Operacao operacao;

	public Operacao soma(double x, double y)
	{
		this.operacao = new Operacao(x, y, "+", x + y);
		return operacao;
	}

	public Operacao subtracao(double x, double y)
	{
		this.operacao = new Operacao(x, y, "-", x - y);
		return operacao;
	}

	public Operacao multiplicacao(double x, double y)
	{
		this.operacao = new Operacao(x, y, "*", x * y);
		return operacao;
	}

	public Operacao divisao(double x, double y)
	{
		this.operacao = new Operacao(x, y, "/", x / y);
		return operacao;
	}

	public void salvarMemento()
	{
		System.out.println("Salvar!");
		operacoesSalvas.push(new Memento(operacao));
	}

	public Operacao desfazer()
	{
		if (operacoesSalvas.isEmpty())
			return null;
		System.out.println("Desfazer!");
		Memento m = operacoesSalvas.pop();
		operacao = m.getOperacao();
		return operacao;
	}

	public Operacao getOperacao()
	{
		return operacao;
	}

	public Stack<Memento> getOperacoesSalvas()
	{
		return operacoesSalvas;
	}
}

class Memento
{
	private Operacao operacao;

	public Memento(Operacao operacao)
	{
		this.operacao = operacao;
	}

	public Operacao getOperacao()
	{
		return operacao;
	}
}