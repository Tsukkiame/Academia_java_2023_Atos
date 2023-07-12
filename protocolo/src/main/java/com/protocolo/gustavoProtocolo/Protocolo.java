package com.protocolo.gustavoProtocolo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "tb_protocolo")
@Entity
@Data // em consjunto com allargs e noargs deixa de ser obrigatória a criação dos getters e setters
@AllArgsConstructor
@NoArgsConstructor
public class Protocolo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String doc;
	private String obsProtocolo;
	private String usuarioEnvio;
	private String setor;
	private String setorDestino;
	private String dtEnvio;
	
	/*public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getObsProtocolo() {
		return obsProtocolo;
	}
	public void setObsProtocolo(String obsProtocolo) {
		this.obsProtocolo = obsProtocolo;
	}
	public String getUsuarioEnvio() {
		return usuarioEnvio;
	}
	public void setUsuarioEnvio(String usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getSetorDestino() {
		return setorDestino;
	}
	public void setSetorDestino(String setorDestino) {
		this.setorDestino = setorDestino;
	}
	public String getDtEnvio() {
		return dtEnvio;
	}
	public void setDtEnvio(String dtEnvio) {
		this.dtEnvio = dtEnvio;
	}
	public Protocolo(long id, String doc, String obsProtocolo, String usuarioEnvio, String setor, String setorDestino,
			String dtEnvio) {
		this.id = id;
		this.doc = doc;
		this.obsProtocolo = obsProtocolo;
		this.usuarioEnvio = usuarioEnvio;
		this.setor = setor;
		this.setorDestino = setorDestino;
		this.dtEnvio = dtEnvio;
	}
	public Protocolo() {
	}
	public Protocolo(String doc, String obsProtocolo, String usuarioEnvio, String setor, String setorDestino,
			String dtEnvio) {
		super();
		this.doc = doc;
		this.obsProtocolo = obsProtocolo;
		this.usuarioEnvio = usuarioEnvio;
		this.setor = setor;
		this.setorDestino = setorDestino;
		this.dtEnvio = dtEnvio;
	}*/
	
}
