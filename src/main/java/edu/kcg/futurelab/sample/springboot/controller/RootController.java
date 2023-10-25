package edu.kcg.futurelab.sample.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kcg.futurelab.sample.springboot.config.application.ToolsConfig;
import jakarta.annotation.PostConstruct;

@Controller
public class RootController {
	@PostConstruct
	private void init(){
		var tools = toolsConfig.getTools();
		names = new String[tools.length];
		for(var i = 0; i < tools.length; i++){
			names[i] = tools[i].getName();
		}
	}

	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("names", names);
		return "index";
	}

    @Autowired
    private ToolsConfig toolsConfig;
	private String[] names;
}
