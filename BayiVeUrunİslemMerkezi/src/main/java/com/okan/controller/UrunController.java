package com.okan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okan.dao.UrunRepository;
import com.okan.model.Urun;

@RestController
public class UrunController {
	@Autowired
	private UrunRepository repository;

	@PostMapping("/urun_kaydet")
	public Urun bayiKaydet(@RequestBody Urun urun) {
		Urun hataliUrun = new Urun();
		if (urun != null && !urun.getName().trim().equals("") && urun.getPrice() > 0
				&& !urun.getType().trim().equals("")) {
			repository.save(urun);
			return urun;
		} else {

			if (urun.getName().trim().equals(""))
				hataliUrun.setName("Ürünün adı boş olamaz. Kayıt işlemi tamamlanmadı.");
			else if (urun.getPrice() <= 0)
				hataliUrun.setName("Geçerli bir fiyat giriniz. Kayıt işlemi tamamlanmadı.");
			else if (urun.getType().trim().equals(""))
				hataliUrun.setName("Ürünün tipi boş olamaz. Kayıt işlemi tamamlanmadı.");
		}
		return hataliUrun;
	}

	@GetMapping("/tum_urunler")
	public List<Urun> tumBayiler() {
		return repository.findAll();
	}

}
