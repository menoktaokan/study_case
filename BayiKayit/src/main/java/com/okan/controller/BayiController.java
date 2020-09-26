package com.okan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.okan.model.Bayi;

@Controller
public class BayiController {
	
	private static String serverUrl = "http://localhost:8090/";
	private static RestTemplate restTemplate = new RestTemplate();

	@PostMapping("/bayi_kaydet")
	@ResponseBody
	public ResponseEntity<Bayi> bayiKaydet(@RequestBody Bayi bayi) {
		serverUrl+="bayi_kaydet";
		
		ResponseEntity<Bayi> yeniBayi=restTemplate.postForEntity(serverUrl, bayi, Bayi.class);
		serverUrl = "http://localhost:8090/";
		
		return yeniBayi;
	}

}
