package br.unicentro.lod.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.unicentro.lod.services.Constantes;

import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;

public class ControllerUtils implements Serializable {

	public static List<SelectItem> getList(String queryString,
			String valueArgument, String labelArgument, String cabecalho) {

		List<SelectItem> list = new ArrayList<SelectItem>();

		if (cabecalho != null)
			list.add(new SelectItem(cabecalho, cabecalho));
		// cria o objeto para consulta
		com.hp.hpl.jena.query.Query query = QueryFactory.create(queryString,
				Constantes.GRAPH_URI);
		QueryEngineHTTP qexec = new QueryEngineHTTP(Constantes.LOCAL_SPARQL,
				query);
		qexec.setTimeout(240000, 240000);
		try {
			ResultSet results = qexec.execSelect();
			// insere os elementos da consulta na lista
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();
				String value = solution.get(valueArgument).asResource()
						.toString();
				String label = solution.get(labelArgument).asLiteral()
						.getValue().toString();
				list.add(new SelectItem(value, label));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("finish by exeption" + e.getMessage());
		}
		return list;
	}

	public static List<SelectItem> getList(String queryString,
			String valueArgument, String labelArgument) {

		List<SelectItem> list = new ArrayList<SelectItem>();

		// cria o objeto para consulta
		com.hp.hpl.jena.query.Query query = QueryFactory.create(queryString,
				Constantes.GRAPH_URI);
		QueryEngineHTTP qexec = new QueryEngineHTTP(Constantes.LOCAL_SPARQL,
				query);
		qexec.setTimeout(240000, 240000);
		try {
			ResultSet results = qexec.execSelect();
			// insere os elementos da consulta na lista
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();
				String value = solution.get(valueArgument).asResource()
						.toString();
				String label = solution.get(labelArgument).asLiteral()
						.getValue().toString();
				list.add(new SelectItem(value, label));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("finish by exeption" + e.getMessage());
		}
		return list;
	}

}
