package com.plateforme;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {
	@GetMapping("/test")
	public String test() {
	    return "Test GitHub Actions";
	}

}
