package exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Calculadora
{

	public static void main(String[] args)
	{
		String entrada = "12 - 3 + ( 67 ) ", aux = "";
		List<String> numeros = new ArrayList<>();
		List<String> simbolos = new ArrayList<>();
		boolean ehNumero = false;
		char c;

		for (int i = 0; i < entrada.length(); i++)
		{
			if (entrada.charAt(i) == ' ')
			{
				for (int j = 0; j < aux.length(); j++)
				{
					c = aux.charAt(j);
					if (c >= 48 && c <= 57)
					{
						ehNumero = true;
					} else if ((c >= 40 && c <= 43 || c == 45 || c == 47) && (aux.length() == 1) && (!ehNumero))
					{

					} else
					{
						System.err.println("ERRO LÉXICO");
						return;
					}
				}
				if (ehNumero)
					numeros.add(aux);
				else
					simbolos.add(aux);
				aux = "";
				ehNumero = false;
			} else
				aux = new StringBuilder().append(aux).append(entrada.charAt(i)).toString();
		}

	}

}
