package br.unicentro.lod.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.unicentro.lod.domain.Cidade;
import br.unicentro.lod.domain.CidadeSUS;
import br.unicentro.lod.services.CidadeService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CidadeViewController implements Serializable
{

	List<Cidade> listaCidades;
	private CidadeService service;

	List<CidadeSUS> listaCidade;
	private CidadeService serviceCidade;
	String gid;

	@PostConstruct
	public void init()
	{
		System.out.println("ok... entrei");
		service = new CidadeService(getQuery(), false);
		setListaCidades(service.getListaCidades());
	}

	public void buttonPressed()
	{
		System.out.println("Botão pressionado");
		serviceCidade = new CidadeService(getQueryCidadeSUS(), true);
		listaCidade = serviceCidade.getListaCidade();
	}

	private String getQuery()
	{

		return "PREFIX dc: <http://purl.org/dc/elements/1.1/>"
				+ "\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "\nPREFIX scovo: <http://purl.org/NET/scovo#>"
				+ "\nPREFIX schema: <http://schema.org/>"
				+ "\nPREFIX rl: <http://lod.unicentro.br/RazaoLeitos/>"
				+ "\nPREFIX xs: <http://www.w3.org/2001/XMLSchema#>"
				+ "\n\nSELECT DISTINCT ?gid ?nomeCidade (xs:double(?razaoMedicosPrivados) as ?razaoMedPrivados) (xs:double(?rzLeitos) as ?razaoLeitos)"
				+ "\nWHERE " + "\n{" + "\n?cidade rdf:type schema:City ."
				+ "\n?cidade rl:gid ?gid ."
				+ "\n?cidade dc:title ?nomeCidade ."
				+ "\n?cidade rl:temItem ?item ."
				+ "\n?item scovo:dimension ?dimRazaoPv ."
				+ "\n?dimRazaoPv rdf:type  rl:RazaoMedicosPrivados ."
				+ "\n?dimRazaoPv rdf:value ?razaoMedicosPrivados ."
				+ "\n?item scovo:dimension ?dimRazao ."
				+ "\n?dimRazao rdf:type  rl:RazaoLeitos ."
				+ "\n?dimRazao rdf:value ?rzLeitos" + "\n}"
				+ "\nORDER BY ?nomeCidade";
	}

	private String getQueryCidadeSUS()
	{
		return "PREFIX dc: <http://purl.org/dc/elements/1.1/>"
				+ "\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "\nPREFIX scovo: <http://purl.org/NET/scovo#>"
				+ "\nPREFIX schema: <http://schema.org/>"
				+ "\nPREFIX rls: <http://lod.unicentro.br/RazaoLeitosSUS/>"
				+ "\nPREFIX xs: <http://www.w3.org/2001/XMLSchema#>"
				+ "\n\nSELECT DISTINCT ?nomeCidade ?nomeEstado ?populacao (xs:integer(?medicosSUS) as ?nMedicosSUS) ?razaoLeitosSUS"
				+ "\nWHERE{" + "\n?cidade rdf:type schema:City ."
				+ "\n?cidade rls:gid " + "'" + getGid() + "' ."
				+ "\n?cidade dc:title ?nomeCidade ."
				+ "\n?cidade rls:temEstado ?estado ."
				+ "\n?estado rdf:type schema:State ."
				+ "\n?estado dc:title ?nomeEstado ."
				+ "\n?cidade rls:temItem ?item ."
				+ "\n?item scovo:dimension ?dimPop ."
				+ "\n?dimPop rdf:type  rls:Populacao ."
				+ "\n?dimPop schema:population ?populacao ."
				+ "\n?item scovo:dimension ?dimNSUS ."
				+ "\n?dimNSUS rdf:type  rls:NumMedicosSUS ."
				+ "\n?dimNSUS rdf:value ?medicosSUS ."
				+ "\n?item scovo:dimension ?dimRazaoSUS ."
				+ "\n?dimRazaoSUS rdf:type  rls:RazaoLeitosSUS ."
				+ "\n?dimRazaoSUS rdf:value ?razaoLeitosSUS" + "\n}"
				+ "\nORDER BY ?nomeCidade";
	}

	public List<Cidade> getListaCidades()
	{
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades)
	{
		this.listaCidades = listaCidades;
	}

	public List<CidadeSUS> getListaCidade()
	{
		return listaCidade;
	}

	public void setListaCidade(List<CidadeSUS> listaCidade)
	{
		this.listaCidade = listaCidade;
	}

	public String getGid()
	{
		return gid;
	}

	public void setGid(String gid)
	{
		this.gid = gid;
	}

}
