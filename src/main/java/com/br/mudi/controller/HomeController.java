package com.br.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.service.PedidoService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoController pedidoController;

	@GetMapping
	public String home(Model model) {

		List<Pedido> arrayPedido = pedidoController.listarPedidos();

		model.addAttribute("pedidos", arrayPedido);

		return "home";
	}

	@GetMapping("/{status}")
	public String aguardando(@PathVariable("status") String status, Model model) {

		List<Pedido> arrayPedido = pedidoController.listarPedidosStatus(StatusPedido.valueOf(status.toUpperCase()));

		model.addAttribute("pedidos", arrayPedido);
		model.addAttribute("status", status);

		return "home";
	}
	
	@ExceptionHandler
	public String onError(IllegalArgumentException illegalArgumentException) {
		return "redirect:/home";
	}

}
