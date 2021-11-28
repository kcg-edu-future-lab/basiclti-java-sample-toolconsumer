package edu.kcg.futurelab.sample.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/go")
public class GoController {
	@GetMapping()
	public String go() {
		return "users/index";
	}
}
