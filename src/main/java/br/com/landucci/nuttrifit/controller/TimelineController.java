package br.com.landucci.nuttrifit.controller;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Atendimento;
import br.com.landucci.nuttrifit.modelo.Usuario;
import br.com.landucci.nuttrifit.service.atendimento.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.landucci.nuttrifit.service.ServiceException;

@Controller
@Transactional
@RequestMapping("/paciente")
public class TimelineController {

	private AtendimentoService atendimentoService;

	@Autowired
	public TimelineController(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

	@RequestMapping(method = RequestMethod.GET, name = "timeline")
	public ModelAndView timeline(RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("paciente/index");
		try {
			Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<Atendimento> atendimentoList = atendimentoService.listarPorPaciente(usuario.getPessoa());
			modelAndView.addObject("atendimentoList", atendimentoList);
			modelAndView.addObject("atendimentoCount", atendimentoList.size());
		} catch (ServiceException e) {
			redirectAttributes.addFlashAttribute("msgErro", e.getMessage());
		}
		return modelAndView;
	}	
}