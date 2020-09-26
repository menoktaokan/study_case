package com.okan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class BayiController {

	private String serverUrl = "http://localhost:8090/";
	private static RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/{bayiAdi}/urunler")
	@ResponseBody
	public String[] bayiUrunleri(@PathVariable String bayiAdi) {
		serverUrl += bayiAdi + "/urunler/";
		ResponseEntity<String[]> response = restTemplate.getForEntity(serverUrl, String[].class);
		String[] urunler = response.getBody();
		serverUrl = "http://localhost:8090/";
		return urunler;
	}

}
