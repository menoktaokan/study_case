package com.okan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okan.dao.BayiRepository;
import com.okan.model.Bayi;

@RestController
public class BayiController {

	@Autowired
	private BayiRepository repository;

	@PostMapping("/bayi_kaydet")
	public Bayi bayiKaydet(@RequestBody Bayi bayi) {
		if (repository.findByName(bayi.getName()) == null && !bayi.getName().trim().equals(""))
			repository.save(bayi);
		else {
			bayi = new Bayi();
			bayi.setName(
					"Bu isimde bir bayi bulunmaktadır ya da bayi ismi boş girilmiştir. Kayıt işlemi gerçekleştirilemedi");
		}
		return bayi;
	}

	@GetMapping("/tum_bayiler")
	public List<Bayi> tumBayiler() {
		return repository.findAll();
	}

	@RequestMapping("bayi_urun_tanimla/{bayiAdi}/urun_ekle")
	public Bayi bayiUrunTanimla(@PathVariable String bayiAdi, @RequestBody String urun) {
		Bayi bayi = new Bayi();
		urun = urun.replaceAll("^\"|\"$", "");
		if(urun.trim().equals("")) {
			bayi.setName("Ürün adı boş olamaz.");
			return bayi;
		}
	
		try {
			bayi = new Bayi();
			if (repository.findByName(bayiAdi) != null) {
				bayi = repository.findByName(bayiAdi);
				int i = bayi.getProductTypes().length;
				String[] list = new String[++i];
				for (int j = 0; j < i - 1; j++) {
					list[j] = bayi.getProductTypes()[j];
				}
				list[i - 1] = urun;
				bayi.setProductTypes(list);
				repository.save(bayi);
			} else
				bayi.setName("Girdiğiniz isimde bir bayi bulunmadı.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bayi;
	}

	@GetMapping("/{bayiAdi}/urunler")
	public String[] bayiUrunleriListele(@PathVariable String bayiAdi) {
		Bayi bayi = new Bayi();
		if (repository.findByName(bayiAdi) != null && !bayiAdi.trim().equals(""))
			bayi = repository.findByName(bayiAdi);
		else
			bayi.setProductTypes(new String[] { "Bu isimde bir bayi bulunmaktadır ya da bayi ismi boş girilmiştir. " });

		return bayi.getProductTypes();
	}

	@GetMapping("/{bayiAdi}")
	public Bayi bayiGoruntule(@PathVariable String bayiAdi) {
		Bayi bayi = new Bayi();
		try {
			if (repository.findByName(bayiAdi) != null)
				bayi = repository.findByName(bayiAdi);
			else
				bayi.setName("Girdiğiniz isimde bir bayi bulunmadı.");
		} catch (javax.persistence.NonUniqueResultException e) {

			e.printStackTrace();
		}

		return bayi;
	}
}
