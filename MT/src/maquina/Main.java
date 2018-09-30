package maquina;

import java.util.HashMap;

public class Main
{

	public static void main(String[] args)
	{
		Character[] alfabetoMT =
		{ 'a', 'b' };

		Character[] alfabetoEstados =
		{ 'a', 'b', 'λ' };

		/*
		 * public Estado(nome, caracteresLeitura, caracteresEscrita, movimentos,
		 * proximosEstados)
		 */

		Estado q0 = new Estado("q0", alfabetoEstados, new Character[]
		{ 'λ', 'λ', 'λ' }, new Movimento[]
		{ Movimento.RIGHT, Movimento.RIGHT, Movimento.END }, new String[]
		{ "A", "B", "qAceita" });

		Estado A = new Estado("A", alfabetoEstados, new Character[]
		{ 'a', 'b', 'λ' }, new Movimento[]
		{ Movimento.RIGHT, Movimento.RIGHT, Movimento.LEFT }, new String[]
		{ "A", "A", "Al" });

		Estado B = new Estado("B", alfabetoEstados, new Character[]
		{ 'a', 'b', 'λ' }, new Movimento[]
		{ Movimento.RIGHT, Movimento.RIGHT, Movimento.LEFT }, new String[]
		{ "B", "B", "Bl" });

		Estado Al = new Estado("Al", alfabetoEstados, new Character[]
		{ 'λ', 'λ', 'λ' }, new Movimento[]
		{ Movimento.LEFT, Movimento.END, Movimento.END }, new String[]
		{ "L", "qRejeita", "qAceita" });

		Estado Bl = new Estado("Bl", alfabetoEstados, new Character[]
		{ 'λ', 'λ', 'λ' }, new Movimento[]
		{ Movimento.END, Movimento.LEFT, Movimento.END }, new String[]
		{ "qRejeita", "L", "qAceita" });

		Estado L = new Estado("L", alfabetoEstados, new Character[]
		{ 'a', 'b', 'λ' }, new Movimento[]
		{ Movimento.LEFT, Movimento.LEFT, Movimento.RIGHT }, new String[]
		{ "L", "L", "q0" });

		Estado qAceita = new Estado("qAceita", alfabetoEstados, new Character[]
		{ 'λ', 'λ', 'λ' }, new Movimento[]
		{ Movimento.END, Movimento.END, Movimento.END }, new String[]
		{ "qAceita", "qAceita", "qAceita" });

		Estado qRejeita = new Estado("qRejeita", alfabetoEstados,
				new Character[]
				{ 'λ', 'λ', 'λ' }, new Movimento[]
				{ Movimento.END, Movimento.END, Movimento.END }, new String[]
				{ "qRejeita", "qRejeita", "qRejeita" });

		HashMap<String, Estado> estados = new HashMap<>();
		estados.put(q0.getNome(), q0);
		estados.put(A.getNome(), A);
		estados.put(B.getNome(), B);
		estados.put(Al.getNome(), Al);
		estados.put(Bl.getNome(), Bl);
		estados.put(L.getNome(), L);
		estados.put(qAceita.getNome(), qAceita);
		estados.put(qRejeita.getNome(), qRejeita);

		MaquinaTuring MT = new MaquinaTuring(estados, alfabetoMT, "qAceita",
				"qRejeita", "q0");

		System.out.println(MT.processar(""));
	}
}
