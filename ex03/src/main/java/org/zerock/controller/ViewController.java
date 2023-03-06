package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/view/all")
	public void all() {
		
	}
	
	@GetMapping("view/quiz1")
	public void viewquiz1() {
		
	}
}
