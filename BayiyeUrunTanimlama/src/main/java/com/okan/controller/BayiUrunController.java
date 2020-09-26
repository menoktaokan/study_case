package com.okan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.okan.model.Bayi;

@Controller
public class BayiUrunController {

	private static String serverUrl = "http://localhost:8090/";
	private static RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("bayi_urun_tanimla/{bayiAdi}/urun_ekle")
	@ResponseBody
	public ResponseEntity<Bayi> bayiUrunTanimla(@PathVariable String bayiAdi, @RequestBody String urun) {
		serverUrl += "bayi_urun_tanimla/" + bayiAdi + "/urun_ekle";
		ResponseEntity<Bayi> urunEkle = restTemplate.postForEntity(serverUrl, urun, Bayi.class);
		serverUrl = "http://localhost:8090/";
		
//		Bayi bayi = restTemplate.getForObject(serverUrl + bayiName, Bayi.class);
		serverUrl = "http://localhost:8090/";
		return urunEkle;
	}

}
