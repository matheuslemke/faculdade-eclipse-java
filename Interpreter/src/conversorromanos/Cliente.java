package conversorromanos;

import java.util.ArrayList;

public class Cliente
{

	public static void main(String[] args)
	{
		String roman = "MCMXXVIII";
		Context context = new Context(roman);

		ArrayList<Expression> tree = new ArrayList<>();

		tree.add(new ThousandExpression());
		tree.add(new HundredExpression());
		tree.add(new TenExpression());
		tree.add(new OneExpression());

		for (Expression exp : tree)
		{
			exp.interpret(context);
		}
		System.out.println(roman + " = " + context.getOutput());

	}

}
