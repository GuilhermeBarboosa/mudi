package com.br.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.service.PedidoService;
import com.br.mudi.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
public class UserController {

	private UserService userService;
	private PedidoService pedidoService;
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

	@GetMapping("/ofertas")
	public String ofertas(Model model, Principal principal) {

		List<Pedido> arrayPedido = pedidoController.listaOfertas(principal.getName());

		userService.findBy(principal.getName()).ifPresent(user -> model.addAttribute("user", user));

		model.addAttribute("pedidos", arrayPedido);

		return "usuario/ofertas";
	}

	@GetMapping("/ofertas/valor/{id}")
	public String valor(Model model, Principal principal, @PathVariable("id") Long id) {

		pedidoController.procuraPedido(id).ifPresent(pedido -> model.addAttribute("pedido", pedido));

		return "usuario/valor";
	}

	@GetMapping("/update/{id}")
	public String atualizarPreco(Pedido pedidoEnviado, BindingResult result, Principal principal,
			@PathVariable("id") Long id) {
		
		if (result.hasErrors()) {
			return "redirect:usuario/";
		}
	
		Pedido pedidoAtualizado = pedidoService.procuraPedido(id).get();

		userService.findBy(principal.getName()).ifPresent(user -> pedidoEnviado.setUser(user));
		
		pedidoAtualizado.setId(id);
		pedidoAtualizado.setDataEntrega(pedidoEnviado.getDataEntrega());
		pedidoAtualizado.setValor(pedidoEnviado.getValor());
		pedidoAtualizado.setStatus(StatusPedido.APROVADO);
		pedidoService.criarPedido(pedidoAtualizado);

		return "redirect:usuario/";
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
