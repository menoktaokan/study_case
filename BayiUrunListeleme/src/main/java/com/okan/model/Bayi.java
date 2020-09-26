package com.okan.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bayi {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String[] productTypes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(String[] productTypes) {
		this.productTypes = productTypes;
	}

	@Override
	public String toString() {
		return "Bayi [id=" + id + ", name=" + name + ", productTypes=" + Arrays.toString(productTypes) + "]";
	}

}
