package br.com.landucci.nuttrifit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.landucci.nuttrifit.modelo.Usuario;
import br.com.landucci.nuttrifit.service.ServiceException;
import br.com.landucci.nuttrifit.service.usuario.UsuarioService;

@Controller
@Transactional
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, name = "indexUsuario")
	public String index(Model model) {
		try {
			model.addAttribute("usuarioList", service.listar());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "nutricionista/usuario/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, name = "createUsuario")
	public ModelAndView create(Usuario usuario) {
		return new ModelAndView("nutricionista/usuario/create");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, name = "saveUsuario")
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//		if (bindingResult.hasErrors()) {
//			return create(categoria);
//		}

		try {
			service.salvar(usuario);
			redirectAttributes.addFlashAttribute("msgSucesso", "Usuário cadastrado com sucesso.");
		} catch (ServiceException e) {
			redirectAttributes.addFlashAttribute("msgErro", e.getMessage());
		}
		return new ModelAndView("redirect:/usuario/");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, name = "editUsuario")
	public ModelAndView edit(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("nutricionista/usuario/edit");
		try {
			Usuario usuario = loadObject(id);
			modelAndView.addObject("usuario", usuario);
		} catch (ServiceException e) {
			redirectAttributes.addFlashAttribute("msgErro", e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, name = "updateUsuario")
	public ModelAndView update(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//		if (bindingResult.hasErrors()) {
//			return edit(categoria.getId(), redirectAttributes);
//		}

		try {
			service.alterar(usuario);
			redirectAttributes.addFlashAttribute("msgSucesso", "Usuário alterado com sucesso.");
		} catch (ServiceException e) {
			redirectAttributes.addFlashAttribute("msgErro", e.getMessage());
		}
		return new ModelAndView("redirect:/usuario/");
	}

	@RequestMapping(value = "/delete/{id}", name = "deleteUsuario")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuario/");
		try {
			Usuario usuario = loadObject(id);
			service.excluir(usuario);
			redirectAttributes.addFlashAttribute("msgSucesso", "Usuário excluído com sucesso.");
		} catch (ServiceException e) {
			redirectAttributes.addFlashAttribute("msgErro", e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, name = "showUsuario")
	public ModelAndView show(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("nutricionista/usuario/show");
		try {
			Usuario usuario = loadObject(id);
			modelAndView.addObject("usuario", usuario);
		} catch (ServiceException e) {
			redirectAttributes.addFlashAttribute("msgErro", e.getMessage());
		}
		return modelAndView;
	}

	private Usuario loadObject(Long id) throws ServiceException {
		return service.buscar(id);
	}	
}