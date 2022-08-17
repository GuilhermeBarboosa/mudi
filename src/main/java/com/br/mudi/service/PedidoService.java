package com.br.mudi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;
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

	public List<Pedido> readStatus(StatusPedido statusPedido, PageRequest paginacao) {
		return pedidoRepository.findByStatus(statusPedido, paginacao);
	}

	@Transactional
	public List<Pedido> readPedidosUsername(String name) {
		return pedidoRepository.findByUsername(name);
	}

	public List<Pedido> listaStatusUsername(StatusPedido status, String username) {
		return pedidoRepository.listarPedidosStatusUsername(status, username);
	}
	
}
