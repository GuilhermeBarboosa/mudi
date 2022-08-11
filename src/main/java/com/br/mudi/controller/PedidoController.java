package com.br.mudi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mudi.entity.Pedido;
import com.br.mudi.repository.PedidoRepository;
import com.br.mudi.service.PedidoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {
	
	private PedidoRepository pedidoRepository;
	private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> listarPedidos(){
		return pedidoService.read();
	}
}
