package com.munamuna;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MunaMunaController {

	private MunaDao dao;

	@Autowired
	public MunaMunaController (MunaDao dao) {
		
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Munamuna messageboard");

		return "app";
	}

	@RequestMapping(value = "/muna", method = RequestMethod.POST)
	public String postMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("data", "{id:'new'}");
		
		return "muna";
	}

	@RequestMapping(value = "/muna/{id}", method = RequestMethod.GET)
	public String getMuna(@PathVariable("id") long id, ModelMap model) {
		Muna muna;
		JSONObject o = new JSONObject();
		muna = this.dao.getMuna(id);
		if (muna != null) {
			o.put("id", muna.id);
			o.put("text", muna.text);
			o.put("date", muna.date);
			model.addAttribute("data","{id:" + muna.id + "}");
		};
		model.addAttribute("data", o.toString());
		return "muna";
	}

	@RequestMapping(value = "/muna/{id}", method = RequestMethod.PUT)
	public String putMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("data", "");

		return "muna";
	}

	@RequestMapping(value = "/muna/{id}", method = RequestMethod.DELETE)
	public String deleteMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("data", "");

		return "muna";
	}

}
