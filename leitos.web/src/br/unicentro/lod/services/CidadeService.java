package br.unicentro.lod.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.unicentro.lod.domain.Cidade;
import br.unicentro.lod.domain.CidadeSUS;

import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;

public class CidadeService implements Serializable
{

	private List<Cidade> listaCidades = new ArrayList<Cidade>();
	private List<CidadeSUS> listaCidade = new ArrayList<CidadeSUS>();

	public CidadeService(String queryString, boolean cidadeUnica)
	{
		if (cidadeUnica)
		{
			// System.out.println(queryString);
			com.hp.hpl.jena.query.Query query = QueryFactory.create(
					queryString, Constantes.GRAPH_URI_SUS);
			QueryEngineHTTP qexec = new QueryEngineHTTP(
					Constantes.LOCAL_SPARQL, query);
			qexec.setTimeout(180000, 180000);
			ResultSet consulta = qexec.execSelect();
			while (consulta.hasNext())
			{
				QuerySolution linha = consulta.nextSolution();
				CidadeSUS cidade = new CidadeSUS(linha.get("nomeCidade")
						.asLiteral().getValue().toString(), linha
						.get("nomeEstado").asLiteral().getValue().toString(),
						linha.get("populacao").asLiteral().getValue()
								.toString(), linha.get("nMedicosSUS")
								.asLiteral().getInt(), linha
								.get("razaoLeitosSUS").asLiteral().getDouble());
				listaCidade.add(cidade);
				// System.out.println(cidade);
			}
		} else
		{
			// System.out.println(queryString);
			com.hp.hpl.jena.query.Query query = QueryFactory.create(
					queryString, Constantes.GRAPH_URI);
			QueryEngineHTTP qexec = new QueryEngineHTTP(
					Constantes.LOCAL_SPARQL, query);
			qexec.setTimeout(180000, 180000);
			ResultSet consulta = qexec.execSelect();
			while (consulta.hasNext())
			{
				QuerySolution linha = consulta.nextSolution();
				Cidade cidade = new Cidade(linha.get("gid").asLiteral()
						.getValue().toString(), linha.get("nomeCidade")
						.asLiteral().getValue().toString(), linha
						.get("razaoMedPrivados").asLiteral().getDouble(), linha
						.get("razaoLeitos").asLiteral().getDouble());
				listaCidades.add(cidade);
				// System.out.println(cidade);
			}
		}
	}

	public List<Cidade> getListaCidades()
	{
		return listaCidades;
	}

	public List<CidadeSUS> getListaCidade()
	{
		return listaCidade;
	}

}
