package com.jld.keycloackapi.infrastructure.data.model.document;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "resource")
public class ResourceDocument {

	@MongoId
	private ObjectId _id;
	private String nome;
	private Long id_ultimo_usuario;
	private String descricao;
	private String modelo;
	private String caracteristicas;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId_ultimo_usuario() {
		return id_ultimo_usuario;
	}

	public void setId_ultimo_usuario(Long id_ultimo_usuario) {
		this.id_ultimo_usuario = id_ultimo_usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
}
