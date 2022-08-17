package com.br.mudi.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.br.mudi.entity.Pedido;
import com.br.mudi.entity.StatusPedido;
import com.br.mudi.entity.User;
import com.br.mudi.repository.UserRepository;
import com.br.mudi.service.PedidoService;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/pedido")
public class FormularioController {

	private PedidoService pedidoService;
	private UserRepository userRepository;

	@GetMapping("/formulario")
	public String formulario(Pedido pedidoEnviado) {
		return "pedidos/formulario";
	}

	@PostMapping("/novo")
	public String criarPedido(@Valid Pedido pedidoEnviado, BindingResult result, Principal principal
			) {
		if (result.hasErrors()) {
			return "pedidos/formulario";
		}

		//Optional<User> user = userRepository.findById(usuarioLogado.getUsername());

		userRepository.findById(principal.getName()).ifPresent(user -> pedidoEnviado.setUser(user));
	
		pedidoEnviado.setStatus(StatusPedido.AGUARDANDO);
		pedidoService.criarPedido(pedidoEnviado);

		return "redirect:/home";
	}

}
