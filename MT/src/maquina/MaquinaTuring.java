package maquina;

import java.util.HashMap;

public class MaquinaTuring
{
	private HashMap<String, Estado> estados;
	private Character[] alfabeto;
	private Character[] alfabetoFita;
	private String str_estadoAceitacao;
	private String str_estadoRejeicao;
	private String str_estadoInicial;

	public MaquinaTuring(HashMap<String, Estado> estados, Character[] alfabeto,
			String estadoAceitacao, String estadoRejeicao,
			String str_estadoInicial)
	{
		this.estados = estados;
		this.alfabeto = alfabeto;
		this.str_estadoAceitacao = estadoAceitacao;
		this.str_estadoRejeicao = estadoRejeicao;
		gerarAlfabetoFita();
		this.str_estadoInicial = str_estadoInicial;
	}

	private void gerarAlfabetoFita()
	{
		this.alfabetoFita = new Character[this.alfabeto.length + 1];
		for (int i = 0; i < this.alfabeto.length; i++)
		{
			this.alfabetoFita[i] = this.alfabeto[i];
		}
		this.alfabetoFita[this.alfabeto.length] = 'λ';
	}

	public boolean processar(String entrada)
	{
		Character vetorCharacterEntrada[] = tratarEntrada(entrada);
		Estado estadoAtual = estados.get(str_estadoInicial);

		Character simboloAtual;

		Character caracterEscrever;
		Movimento proximoMovimentoFita;
		String str_proximoEstado;
		Estado proximoEstado;

		int posicaoVetoresEstado;

		for (int i = 1; (i > -1) && (i < vetorCharacterEntrada.length);)
		{
			simboloAtual = vetorCharacterEntrada[i];
			posicaoVetoresEstado = descobrirPosicaoAtual(estadoAtual,
					simboloAtual);
			proximoMovimentoFita = estadoAtual.getMovimentos()[posicaoVetoresEstado];
			caracterEscrever = estadoAtual.getCaracteresEscrita()[posicaoVetoresEstado];
			str_proximoEstado = estadoAtual.getProximosEstados()[posicaoVetoresEstado];
			proximoEstado = estados.get(str_proximoEstado);
			i = executarProximoPasso(caracterEscrever, proximoMovimentoFita,
					proximoEstado, vetorCharacterEntrada, i);
			if (i == -1)
				return false;
			else if (i == vetorCharacterEntrada.length)
				return true;
			estadoAtual = proximoEstado;
		}
		return false;
	}

	private Character[] tratarEntrada(String entrada)
	{
		Character[] retorno = new Character[entrada.length() + 2];
		retorno[0] = 'λ';
		for (int i = 1; i < entrada.length() + 1; i++)
		{
			retorno[i] = entrada.charAt(i - 1);
		}
		retorno[entrada.length() + 1] = 'λ';
		return retorno;
	}

	private int descobrirPosicaoAtual(Estado estadoAtual, Character simboloAtual)
	{
		for (int i = 0; i < estadoAtual.getCaracteresLeitura().length; i++)
		{
			if (estadoAtual.getCaracteresLeitura()[i].compareTo(simboloAtual) == 0)
				return i;
		}
		return -1;
	}

	private int executarProximoPasso(Character caracterEscrever,
			Movimento proximoMovimentoFita, Estado proximoEstado,
			Character[] vetorCharacterEntrada, int i)
	{
		vetorCharacterEntrada[i] = caracterEscrever;
		if (proximoEstado.getNome().compareTo(str_estadoAceitacao) == 0)
			return vetorCharacterEntrada.length;
		if (proximoEstado.getNome().compareTo(str_estadoRejeicao) == 0)
			return -1;
		if (proximoMovimentoFita.compareTo(Movimento.LEFT) == 0)
			return i - 1;
		if (proximoMovimentoFita.compareTo(Movimento.RIGHT) == 0)
			return i + 1;
		return 0;
	}

}
