package br.com.landucci.nuttrifit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@RequestMapping("/nutricionista")
public class DashboardController {
	
	@RequestMapping(method = RequestMethod.GET, name = "dashboard")
	public ModelAndView timeline() {
		return new ModelAndView("nutricionista/index");
	}	
}