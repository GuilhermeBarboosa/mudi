package com.br.mudi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank
	@JoinColumn(name = "nome_produto")
	private String nomeProduto;

	@JoinColumn(name = "valor")
	private BigDecimal valor;
	
	@JoinColumn(name = "data_entrega")
	private LocalDate dataEntrega;

	@NotBlank
	@JoinColumn(name = "url_produto")
	private String urlProduto;

	@NotBlank
	@JoinColumn(name = "url_imagem")
	private String urlImagem;

	@NotBlank
	@JoinColumn(name = "descricao")
	private String descricao;


}
