package com.br.mudi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.repository.PedidoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoService {

	private PedidoRepository pedidoRepository;

	@Transactional
	public List<Pedido> read() {
		return pedidoRepository.findAll();
	}

	@Transactional
	public Pedido criarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public List<Pedido> readStatus(StatusPedido statusPedido) {
		return pedidoRepository.findByStatus(statusPedido);
	}

	@Transactional
	public List<Pedido> readPedidosUsername(String name) {
		return pedidoRepository.findByUsername(name);
	}
	
}
