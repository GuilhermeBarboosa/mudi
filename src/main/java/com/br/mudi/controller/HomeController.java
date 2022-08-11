package com.br.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mudi.entity.Pedido;
import com.br.mudi.service.PedidoService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	private PedidoController pedidoController;

	@GetMapping("/home")
	public String home(Model model) {
		
		List<Pedido> arrayPedido = pedidoController.listarPedidos();
		
		model.addAttribute("pedidos", arrayPedido);
		
		return "home";
	}
}
