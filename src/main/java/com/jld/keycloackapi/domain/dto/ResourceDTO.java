package com.jld.keycloackapi.domain.dto;

public class ResourceDTO {

	private String nome;
	private Long id_ultimo_usuario;
	private String descricao;
	private String modelo;
	private String caracteristicas;

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
