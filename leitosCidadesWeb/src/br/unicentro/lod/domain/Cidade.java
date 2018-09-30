package br.unicentro.lod.domain;

public class Cidade {

	private String gid;
	private String nomeCidade;
	private String link;

	public Cidade(String gid, String nomeCidade, String link) {
		super();
		this.gid = gid;
		this.nomeCidade = nomeCidade;
		this.link = link;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String toString() {
		return getGid() + "  " + getNomeCidade() + "  " + getLink();
	}
}