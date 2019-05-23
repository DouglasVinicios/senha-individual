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
@RequestMapping("/menu/local-eventos")
public class LocalEventoController {
	@Autowired
	private LocalEventoDAO localEventoRep;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/local-eventos/lista-locais");
		mv.addObject("locaisEventos", localEventoRep.findAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarNovoEvento() {
		ModelAndView mv = new ModelAndView("/local-eventos/cadastro-local-evento");
		mv.addObject("localEvento", new LocalEvento());
		return mv;
	}
	
	@PostMapping("/addLocal")
	public ModelAndView addEvento(@ModelAttribute LocalEvento localEvento) {
		ModelAndView mv = new ModelAndView("redirect:/menu/local-eventos");
		localEventoRep.save(localEvento);
		return mv;
	}
	
	@GetMapping("/editar")
	public ModelAndView editarEvento(@RequestParam Integer id) {
		ModelAndView mv = new ModelAndView("/local-eventos/cadastro-local-evento");
		mv.addObject("localEvento", localEventoRep.getOne(id));
		return mv;
	}
	
	@GetMapping("/remover")
	public ModelAndView removerEvento(@RequestParam Integer id) {
		localEventoRep.deleteById(id);
		return new ModelAndView("redirect:/menu/local-eventos");
	}
}
