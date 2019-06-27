package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu/local-eventos")
public class LocalEventoController {
	@Autowired
	private LocalEventoDAO localEventoRep;
	
	@GetMapping("")
	public ModelAndView exibirLocais() {
		ModelAndView mv = new ModelAndView("/local-eventos/lista-locais");
		mv.addObject("locaisEventos", this.localEventoRep.findAll(Sort.by("endereco.nome")));
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarNovoEvento() {
		ModelAndView mv = new ModelAndView("/local-eventos/cadastro-local-evento");
		mv.addObject("localEvento", new LocalEvento());
		return mv;
	}
	
	@PostMapping("/addLocal")
	public ModelAndView addEvento(@Valid LocalEvento localEvento, BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mv = new ModelAndView("/local-eventos/cadastro-local-evento");
			return mv;
		}
		localEventoRep.save(localEvento);
		return exibirLocais();
	}
	
	@GetMapping("/editar")
	public ModelAndView editarLocalEvento(LocalEvento localEvento) {
		ModelAndView mv = new ModelAndView("/local-eventos/cadastro-local-evento");
		if(localEvento != null && localEvento.getCodigo() != null) {
			mv.addObject("localEvento", this.localEventoRep.getOne(localEvento.getCodigo()));
		}else {
			mv.addObject("localEvento", new LocalEvento());
		}
		return mv;
	}
	
	@GetMapping("/remover")
	public ModelAndView removerEvento(LocalEvento localEvento) {
		if(localEvento != null && localEvento.getCodigo() != null) {
			this.localEventoRep.delete(localEvento);
		}
		return new ModelAndView("redirect:/menu/local-eventos");
	}
}
