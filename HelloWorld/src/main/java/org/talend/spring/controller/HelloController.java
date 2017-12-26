package org.talend.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	List<String> names = new ArrayList<String>();
	
	@GetMapping("/hello")
	public String hello(Model model) {
		names.add("John Doe");
		model.addAttribute("name", "John Doe-" + names);
		return "welcome";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(Model model, @RequestParam(value="user", required = false) String user) {
		this.addUser(names, user);
		model.addAttribute("name", names);

		return "welcome";
	}

	public void addUser(List<String> users, String user) {
		if(!users.contains(user)) {
			users.add(user);
		}
	}
}
