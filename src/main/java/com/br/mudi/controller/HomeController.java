package com.br.mudi.controller;

import java.security.Principal;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.entity.User;
import com.br.mudi.repository.PedidoRepository;
import com.br.mudi.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {

	private PedidoController pedidoController;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 1, sort);
		
		List<Pedido> arrayPedido = pedidoController.listarPedidosStatus(StatusPedido.ENTREGUE, paginacao);

		model.addAttribute("pedidos", arrayPedido);
		
		return "home";
	}

}
