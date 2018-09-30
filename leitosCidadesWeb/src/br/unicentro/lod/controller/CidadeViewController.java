package br.unicentro.lod.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.unicentro.lod.domain.Cidade;
import br.unicentro.lod.services.CidadeService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CidadeViewController implements Serializable {

	List<Cidade> listaCidades;
	private CidadeService service;

	@PostConstruct
	public void init() {
		System.out.println("ok... entrei");
		service = new CidadeService(getQuery());
		setListaCidades(service.getListaCidades());
	}

	private String getQuery() {

		return "PREFIX dc: <http://purl.org/dc/elements/1.1/> "
				+ "\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "\nPREFIX schema: <http://schema.org/> "
				+ "\nPREFIX rl: <http://lod.unicentro.br/RazaoLeitos/> " +

				"\n\nSELECT DISTINCT ?gid ?nomeCidade ?link " + "\nWHERE "
				+ "\n{" + "\n?cidade rdf:type schema:City ."
				+ "\n?cidade rl:gid ?gid ."
				+ "\n?cidade dc:title ?nomeCidade ."
				+ "\n?cidade rdfs:seeAlso ?link" + "\n}"
				+ "\nORDER BY ?nomeCidade";
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}
}