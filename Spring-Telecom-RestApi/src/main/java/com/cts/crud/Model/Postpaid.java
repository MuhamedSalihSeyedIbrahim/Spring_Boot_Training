package com.cts.crud.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="postpaid")
public class Postpaid  extends OfferPackage{
	
	private String OfferPackage;
	private String offerdays;
	
	public Postpaid() {
		
	}

	public Postpaid(Long offer_id, String offer_name, double price, String offerPackage, String offerdays) {
		super(offer_id, offer_name, price);
		OfferPackage = offerPackage;
		this.offerdays = offerdays;
	}

	public String getOfferPackage() {
		return OfferPackage;
	}

	public void setOfferPackage(String offerPackage) {
		OfferPackage = offerPackage;
	}

	public String getOfferdays() {
		return offerdays;
	}

	public void setOfferdays(String offerdays) {
		this.offerdays = offerdays;
	}

	@Override
	public String toString() {
		return "Postpaid [OfferPackage=" + OfferPackage + ", offerdays=" + offerdays + "]";
	}
	
	
	
	
}
