package com.br.mudi.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.service.PedidoService;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@AllArgsConstructor
@RequestMapping("/pedido")
public class FormularioController {

	private PedidoService pedidoService;

	@GetMapping("/formulario")
	public String formulario(Pedido pedidoEnviado) {
		return "pedidos/formulario";
	}
	
	@PostMapping("/novo")
	public String criarPedido(@Valid Pedido pedidoEnviado, BindingResult result) {
		if(result.hasErrors()){
			return "pedidos/formulario";
		}
	
		pedidoEnviado.setStatus(StatusPedido.AGUARDANDO);
		
		pedidoService.criarPedido(pedidoEnviado);
		return "redirect:/home";
	}
	
	
	
}
