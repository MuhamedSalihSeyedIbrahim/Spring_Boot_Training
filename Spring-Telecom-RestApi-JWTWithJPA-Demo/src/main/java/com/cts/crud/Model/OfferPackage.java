package com.cts.crud.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Offers")
@Inheritance(strategy = InheritanceType.JOINED)
public class OfferPackage {
	
	@Id
	private Long offer_id;
	
	private String offer_name;
	
	private double price;
	
	public OfferPackage() {}
	
	
	

	public OfferPackage(Long offer_id, String offer_name, double price) {
		super();
		this.offer_id = offer_id;
		this.offer_name = offer_name;
		this.price = price;
	}




	public Long getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(Long offer_id) {
		this.offer_id = offer_id;
	}

	public String getOffer_name() {
		return offer_name;
	}

	public void setOffer_name(String offer_name) {
		this.offer_name = offer_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OfferPackage [offer_id=" + offer_id + ", offer_name=" + offer_name  
				+ ", price=" + price + "]";
	}

	
	
}
