package com.cts.sbwmd.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="PackageOffers")
public class PackageOffers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotEmpty(message = "OfferName can not be empty")
	@NotNull(message = "OfferName can not be omitted")
	private String offerName;
	
	@NotEmpty(message = "ValidityPeriod can not be empty")
	@NotNull(message = "ValidityPeriod can not be omitted")
	private int ValidityPeriod;
	
	@NotEmpty(message = "Description can not be empty")
	@NotNull(message = "Description can not be omitted")
	private String Description;
	
	@NotEmpty(message = "Cost can not be empty")
	@NotNull(message = "Cost can not be omitted")
	private Double Cost;

	
	@Enumerated(EnumType.STRING)
	private Scheme simScheme;
	
	



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public int getValidityPeriod() {
		return ValidityPeriod;
	}

	public void setValidityPeriod(int validityPeriod) {
		ValidityPeriod = validityPeriod;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Double getCost() {
		return Cost;
	}

	public void setCost(Double cost) {
		Cost = cost;
	}

	public Scheme getSimScheme() {
		return simScheme;
	}

	public void setSimScheme(Scheme simScheme) {
		this.simScheme = simScheme;
	}

	public PackageOffers(
			@NotEmpty(message = "OfferName can not be empty") @NotNull(message = "OfferName can not be omitted") String offerName,
			@NotEmpty(message = "ValidityPeriod can not be empty") @NotNull(message = "ValidityPeriod can not be omitted") int validityPeriod,
			@NotEmpty(message = "Description can not be empty") @NotNull(message = "Description can not be omitted") String description,
			@NotEmpty(message = "Cost can not be empty") @NotNull(message = "Cost can not be omitted") Double cost,
			Scheme simScheme) {
		super();
		this.offerName = offerName;
		ValidityPeriod = validityPeriod;
		Description = description;
		Cost = cost;
		this.simScheme = simScheme;
	}

	public PackageOffers() {
		super();
	}
	
	
	
	
}
