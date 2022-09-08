package com.br.mudi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
