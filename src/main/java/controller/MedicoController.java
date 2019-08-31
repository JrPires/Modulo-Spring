package controller;

import java.util.jar.Attributes;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Medico;
import service.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService service;
	
	@GetMapping("/novo")
	public ModelAndView novo(Medico medico) {
		ModelAndView mv = new ModelAndView("medicos/add");
		mv.addObject("medico", medico);
		return mv;
	}
	
	@GetMapping("/list")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("medicos/list");
		mv.addObject("medicos", this.service.lista());
		return mv;
	}
	
	@GetMapping("save")
	public ModelAndView salvar(@Valid Medico medico, BindingResult result, Model model, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/medicos/list");
		
		if (result.hasErrors()) {
			return novo(medico);
		}
		
		attributes.addFlashAttribute("message", "Contato salvo com sucesso !!");
		this.service.save(medico);
		return mv;
	}
}
