package com.lucas.RPInfoDesafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WorkOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String clientName;
	private String clientAddress;
	private String clientContact;
	private String clientEmail;
	private String equipamentModel;
	private String equipamentBrand;
	private String equipamentProblem;
	
	@Enumerated(EnumType.ORDINAL)
	private workOrderStatus workOrderStatus;
	
	private String orderObservation;
	
	public WorkOrder() {}
	
	public WorkOrder(String clientName) {
		this.clientName = clientName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientContact() {
		return clientContact;
	}
	public void setClientContact(String clientContact) {
		this.clientContact = clientContact;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getEquipamentModel() {
		return equipamentModel;
	}
	public void setEquipamentModel(String equipamentModel) {
		this.equipamentModel = equipamentModel;
	}
	public String getEquipamentBrand() {
		return equipamentBrand;
	}
	public void setEquipamentBrand(String equipamentBrand) {
		this.equipamentBrand = equipamentBrand;
	}
	public String getEquipamentProblem() {
		return equipamentProblem;
	}
	public void setEquipamentProblem(String equipamentProblem) {
		this.equipamentProblem = equipamentProblem;
	}
	public workOrderStatus getWorkOrderStatus() {
		return workOrderStatus;
	}
	public void setWorkOrderStatus(workOrderStatus workOrderStatus) {
		this.workOrderStatus = workOrderStatus;
	}
	public String getOrderObservation() {
		return orderObservation;
	}
	public void setOrderObservation(String orderObservation) {
		this.orderObservation = orderObservation;
	}

	
	
}
