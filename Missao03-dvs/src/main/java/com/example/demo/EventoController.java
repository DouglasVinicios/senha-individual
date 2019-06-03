package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu/eventos")
public class EventoController {
	@Autowired
	private EventoDAO eventoRep;
	@Autowired
	private LocalEventoDAO localEventoRep;
	
	@GetMapping("")
	public ModelAndView exibirEventos() {
		ModelAndView mv = new ModelAndView("/eventos/lista-eventos");
		mv.addObject("evento", new Evento());
		mv.addObject("listaEventos", this.eventoRep.findAll(Sort.by("nomeEvento")));
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView pesquisarEvento(@RequestParam(required = false) String nomePesquisado) {
		ModelAndView mv = new ModelAndView("/eventos/lista-eventos");
		mv.addObject("evento", new Evento());
		if(nomePesquisado == null || nomePesquisado.trim().isEmpty()) {
			mv.addObject("listaEventos", this.eventoRep.findAll(Sort.by("nomeEvento")));
		}else {
			mv.addObject("listaEventos", this.eventoRep.findByNomeEventoContainingIgnoreCase(nomePesquisado));
		}
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarNovoEvento() {
		ModelAndView mv = new ModelAndView("/eventos/cadastro-evento");
		mv.addObject("evento", new Evento());
		mv.addObject("locaisEventos", this.localEventoRep.findAll(Sort.by("endereco.nome")));
		return mv;
	}
	
	@PostMapping("/addEvento")
	public ModelAndView addEvento(@Valid Evento evento, BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mv = new ModelAndView("/eventos/cadastro-evento");
			mv.addObject("locaisEventos", this.localEventoRep.findAll(Sort.by("endereco.nome")));
			return mv;
		}
		eventoRep.save(evento);
		return exibirEventos();
	}
	
	@GetMapping("/editar")
	public ModelAndView editarEvento(Evento evento) {
		ModelAndView mv = new ModelAndView("/eventos/cadastro-evento");
		mv.addObject("locaisEventos", localEventoRep.findAll(Sort.by("endereco.nome")));
		if(evento != null && evento.getCodigo() != null) {
			mv.addObject("evento", this.eventoRep.getOne(evento.getCodigo()));
		}else {
			mv.addObject("evento", new Evento());
		}
		return mv;
	}
	
	@GetMapping("/remover")
	public ModelAndView removerEvento(Evento evento) {
		if(evento != null && evento.getCodigo() != null) {
			this.eventoRep.delete(evento);
		}
		return new ModelAndView("redirect:/menu/eventos");
	}
	
}
