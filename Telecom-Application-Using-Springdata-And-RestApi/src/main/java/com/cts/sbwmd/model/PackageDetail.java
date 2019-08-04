package com.cts.sbwmd.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table(name="packageDetail")
public class PackageDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;


	private Long planID;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate SubscriptionStartDate,SubscriptionEndDate;
	
	@NotEmpty(message = "Description can not be empty")
	@NotNull(message = "Description can not be omitted")
	private String Description;
	
	private Double Cost;
	
	@OneToOne(mappedBy="packageDetailChoosed")
	private customer Customeropted;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getSubscriptionStartDate() {
		return SubscriptionStartDate;
	}

	public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
		SubscriptionStartDate = subscriptionStartDate;
	}

	public LocalDate getSubscriptionEndDate() {
		return SubscriptionEndDate;
	}

	public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
		SubscriptionEndDate = subscriptionEndDate;
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

	public customer getCustomeropted() {
		return Customeropted;
	}

	public void setCustomeropted(customer customeropted) {
		Customeropted = customeropted;
	}



	public PackageDetail(Long id, Long planID, LocalDate subscriptionStartDate, LocalDate subscriptionEndDate,
			@NotEmpty(message = "Description can not be empty") @NotNull(message = "Description can not be omitted") String description,
			@NotEmpty(message = "Cost can not be empty") @NotNull(message = "Cost can not be omitted") Double cost,
			customer customeropted) {
		super();
		Id = id;
		this.planID = planID;
		SubscriptionStartDate = subscriptionStartDate;
		SubscriptionEndDate = subscriptionEndDate;
		Description = description;
		Cost = cost;
		Customeropted = customeropted;
	}

	public PackageDetail() {
		super();
	}

	public Long getPlanID() {
		return planID;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
	}




	
	
}
