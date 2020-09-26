package com.okan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.okan.model.Urun;

@Controller
public class UrunController {
	private static String serverUrl = "http://localhost:8090/";
	private static RestTemplate restTemplate = new RestTemplate();

	@PostMapping("/urun_kaydet")
	@ResponseBody
	public ResponseEntity<Urun> urunKaydet(@RequestBody Urun urun) {
		serverUrl+="urun_kaydet";
		
		ResponseEntity<Urun> yeniUrun=restTemplate.postForEntity(serverUrl, urun, Urun.class);
		serverUrl = "http://localhost:8090/";
		
		return yeniUrun;
	}
}
