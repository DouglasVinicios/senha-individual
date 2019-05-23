package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		mv.addObject("eventos", eventoRep.findAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarNovoEvento() {
		ModelAndView mv = new ModelAndView("/eventos/cadastro-evento");
		mv.addObject("evento", new Evento());
		mv.addObject("locaisEventos", localEventoRep.findAll());
		return mv;
	}
	
	@PostMapping("/addEvento")
	public ModelAndView addEvento(@ModelAttribute Evento evento) {
		ModelAndView mv = new ModelAndView("redirect:/menu/eventos");
		eventoRep.save(evento);
		return mv;
	}
	
	@GetMapping("/editar")
	public ModelAndView editarEvento(@RequestParam Integer id) {
		ModelAndView mv = new ModelAndView("/eventos/cadastro-evento");
		mv.addObject("evento", eventoRep.getOne(id));
		mv.addObject("locaisEventos", localEventoRep.findAll());
		return mv;
	}
	
	@GetMapping("/remover")
	public ModelAndView removerEvento(@RequestParam Integer id) {
		eventoRep.deleteById(id);
		return new ModelAndView("redirect:/menu/eventos");
	}
}
