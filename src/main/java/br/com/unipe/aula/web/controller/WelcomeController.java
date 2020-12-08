package br.com.unipe.aula.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.dao.AlbumDAO;
import br.com.unipe.aula.model.Album;

@Controller
public class WelcomeController {
	
	@Autowired
	private AlbumDAO dao;
	
	public WelcomeController() {
		dao = new AlbumDAO();
	}
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	@RequestMapping(value = "/outroteste", method = RequestMethod.GET)
	public ModelAndView outroTeste() {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("mensagem", "View com parâmetro funcionando com sucesso!");
		
		return view;
	}
	
	@RequestMapping(value = "/formulario", method = RequestMethod.GET)
	public ModelAndView formulario(Model model) {
		model.addAttribute("album", new Album());
		return new ModelAndView("formulario");
	}
	
	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public ModelAndView exibeAlbum(@ModelAttribute Album album) {
		ModelAndView view = new ModelAndView("formulario");
		
		view.addObject("mensagem", album.getNome() + " com autoria de " + album.getInterprete());
		
		return view;
	}
	
	@PostMapping(value = "/cadastro")
	public ModelAndView cadastrarAlbum(@ModelAttribute Album album) {
		
		dao.salvar(album);
		
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Album cadastrado com sucesso");
		view.addObject("albums", dao.getAll());
		
		return view;
	}
	
	@GetMapping(value = "/cadastro")
	public ModelAndView retornarAposExcluir(@ModelAttribute Album album) {
				
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Album cadastrado com sucesso");
		view.addObject("albums", dao.getAll());
		
		return view;
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluirAlbum(@PathVariable("id") Long id, Model model) {
		
		dao.excluir(id);
		
		return "redirect:../cadastro";
	}
	
	@GetMapping(value = "/editar/{id}") 
	public ModelAndView editarAlbum(@PathVariable("id") Long id, Model model){
		
		ModelAndView view = new ModelAndView("editar");
		model.addAttribute("album", dao.getId(id));
		
		return view;
	}
	
	@PostMapping(value = "/update/{id}")
	public String updateAlbum(@ModelAttribute Album album) {
		
		dao.editar(album);
		
		return "redirect:../cadastro";
	}
}
