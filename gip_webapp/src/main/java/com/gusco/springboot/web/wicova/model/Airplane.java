package com.gusco.springboot.web.wicova.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String brand;
	
	@Transient
	private MultipartFile picture;
	
	private String pictureUrl;
	
	@NotNull
	@Min(value=0, message="Vul een prijs in boven 0€.")
	private double price;
	
	private int loopTijd;
	
	private double jaarRente;
	
	private double pmt;

	public Airplane() {
		super();
	}

	public Airplane(int id, String name, String description, String brand, MultipartFile picture, String pictureUrl,
			@NotNull @Min(value = 0, message = "Vul een prijs in boven 0€.") double price, int loopTijd,
			double jaarRente, double pmt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.picture = picture;
		this.pictureUrl = pictureUrl;
		this.price = price;
		this.loopTijd = loopTijd;
		this.jaarRente = jaarRente;
		this.pmt = pmt;
	}
	
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public double getPmt() {
		return pmt;
	}

	public void setPmt(double pmt) {
		this.pmt = pmt;
	}

	public int getLoopTijd() {
		return loopTijd;
	}

	public void setLoopTijd(int loopTijd) {
		this.loopTijd = loopTijd;
	}
	
	public double getJaarRente() {
		return jaarRente;
	}
	
	public void setJaarRente(double jaarRente) {
		this.jaarRente = jaarRente;
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", price=" + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
}
