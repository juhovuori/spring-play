package com.munamuna;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String postMuna(@RequestBody final String request, ModelMap model) {
		System.out.println(request);
		
		JSONObject o = new JSONObject(request);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		String text = o.getString("text");
		Date date;
		try {
			date = format.parse(o.getString("date"));
		} catch (ParseException e) {
			model.addAttribute("data", "{status:'fail date'}");
			return "muna";
		}

		model.addAttribute("data", "{status:'ok'}");
		Muna muna = new Muna();
		muna.setText(text);
		muna.setDate(date);
		this.dao.storeMuna(muna);
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
	public String putMuna(@PathVariable("id") long id, @RequestBody final String request, ModelMap model) {
		JSONObject o = new JSONObject(request);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		String text = o.getString("text");
		Date date;
		Long id2 = o.getLong("id");
		if (id2 != id) {
			model.addAttribute("data", "{status:'wrong id'}");
			return "muna";
		}
		try {
			date = format.parse(o.getString("date"));
		} catch (ParseException e) {
			model.addAttribute("data", "{status:'fail date'}");
			return "muna";
		}

		model.addAttribute("data", "{status:'ok'}");
		Muna muna = new Muna(id, text, date);
		this.dao.storeMuna(muna);
		return "muna";
	}

	@RequestMapping(value = "/muna/{id}", method = RequestMethod.DELETE)
	public String deleteMuna(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("data", "");

		return "muna";
	}

}
