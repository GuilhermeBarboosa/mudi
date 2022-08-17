package com.br.mudi.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.entity.User;
import com.br.mudi.service.PedidoService;
import com.br.mudi.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
public class UserController {

	private UserService userService;
	private PedidoController pedidoController;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/pedido")
	public String home(Model model, Principal principal) {

		List<Pedido> arrayPedido = pedidoController.listaStatusUsernameEntregue(principal.getName());

		userService.findBy(principal.getName()).ifPresent(user -> model.addAttribute("user", user));

		// logger.info("No início do programa principal");

		model.addAttribute("pedidos", arrayPedido);

		return "usuario/home";
	}

	@GetMapping("/pedido/{status}")
	public String aguardando(@PathVariable("status") String status, Model model, Principal principal) {

		List<Pedido> arrayPedido = pedidoController.listaStatusUsername(StatusPedido.valueOf(status.toUpperCase()),
				principal.getName());

		userService.findBy(principal.getName()).ifPresent(user -> model.addAttribute("user", user));

		model.addAttribute("pedidos", arrayPedido);
		model.addAttribute("status", status);

		return "usuario/home";
	}

	@ExceptionHandler
	public String onError(IllegalArgumentException illegalArgumentException) {
		return "redirect:/usuario/home";
	}

}
