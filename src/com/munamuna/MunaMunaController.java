package com.munamuna;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MunaMunaController {

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Munamuna messageboard");

		return "muna";
	}

	@RequestMapping(value = "/muna", method = RequestMethod.POST)
	public String postMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("message", "Munamuna messageboard");

		return "muna";
	}

	@RequestMapping(value = "/muna/{id}", method = RequestMethod.GET)
	public String getMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("message", "Munamuna messageboard");

		return "muna";
	}

	@RequestMapping(value = "/muna/{id}", method = RequestMethod.PUT)
	public String putMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("message", "Munamuna messageboard");

		return "muna";
	}

	@RequestMapping(value = "/muna/{id}", method = RequestMethod.DELETE)
	public String deleteMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("message", "Munamuna messageboard");

		return "muna";
	}

}
