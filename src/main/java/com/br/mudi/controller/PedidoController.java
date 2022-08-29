package com.br.mudi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.repository.PedidoRepository;
import com.br.mudi.service.PedidoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> listarPedidos(){
		return pedidoService.read();
	}

	public List<Pedido> listarPedidosStatus(StatusPedido statusPedido, PageRequest paginacao) {
		return pedidoService.readStatus(statusPedido, paginacao);
	}

	public List<Pedido> listarPedidosUser(String name) {
		return pedidoService.readPedidosUsername(name);
	}

	public List<Pedido> listaStatusUsername(StatusPedido status, String username) {
		return pedidoService.listaStatusUsername(status, username);
	}

	public List<Pedido> listaStatusUsernameEntregue(String name) {
		return pedidoService.listaStatusUsername(StatusPedido.ENTREGUE, name);
	}

	public List<Pedido> listaOfertas(String name) {
		return pedidoService.listaOferta(StatusPedido.AGUARDANDO, name);
	}

	public Optional<Pedido> procuraPedido(Long id) {
		return pedidoService.procuraPedido(id);
	}
	
}
