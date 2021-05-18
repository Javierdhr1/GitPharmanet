 package com.drogueria.pharmanet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1334043694456995283L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@NotBlank
	private Long codebar;
	
	private Long childBarcode;
	
	@NotBlank
	private String nameProduct;
	
	@NotBlank
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Factory factory;
	
	@NotBlank
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Category category;
	
	@NotBlank
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Presentation presentation;
	
	@NotBlank
	private int quantityPresentation;
	
	private String recordInvima;
	
	private int retailBlizter;
	
	private int retailGlobal;
	
	@NotBlank
	private int priceInvoice;
	
	private int saleRetail;
	
	private int saleBlizter; 
	
	private int saleGlobal;
	
	private Date expirationDate;
	
	private Date registrationDate;
	
	private boolean isActive;
	
	private int iva;
	
	private String genericName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodebar() {
		return codebar;
	}

	public void setCodebar(Long codebar) {
		this.codebar = codebar;
	}

	public Long getChildBarcode() {
		return childBarcode;
	}

	public void setChildBarcode(Long childBarcode) {
		this.childBarcode = childBarcode;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

	public int getQuantityPresentation() {
		return quantityPresentation;
	}

	public void setQuantityPresentation(int quantityPresentation) {
		this.quantityPresentation = quantityPresentation;
	}

	public String getRecordInvima() {
		return recordInvima;
	}

	public void setRecordInvima(String recordInvima) {
		this.recordInvima = recordInvima;
	}

	public int getRetailBlizter() {
		return retailBlizter;
	}

	public void setRetailBlizter(int retailBlizter) {
		this.retailBlizter = retailBlizter;
	}

	public int getRetailGlobal() {
		return retailGlobal;
	}

	public void setRetailGlobal(int retailGlobal) {
		this.retailGlobal = retailGlobal;
	}

	public int getPriceInvoice() {
		return priceInvoice;
	}

	public void setPriceInvoice(int priceInvoice) {
		this.priceInvoice = priceInvoice;
	}

	public int getSaleRetail() {
		return saleRetail;
	}

	public void setSaleRetail(int saleRetail) {
		this.saleRetail = saleRetail;
	}

	public int getSaleBlizter() {
		return saleBlizter;
	}

	public void setSaleBlizter(int saleBlizter) {
		this.saleBlizter = saleBlizter;
	}

	public int getSaleGlobal() {
		return saleGlobal;
	}

	public void setSaleGlobal(int saleGlobal) {
		this.saleGlobal = saleGlobal;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", codebar=" + codebar + ", childBarcode=" + childBarcode + ", nameProduct="
				+ nameProduct + ", factory=" + factory + ", category=" + category + ", presentation=" + presentation
				+ ", quantityPresentation=" + quantityPresentation + ", recordInvima=" + recordInvima
				+ ", retailBlizter=" + retailBlizter + ", retailGlobal=" + retailGlobal + ", priceInvoice="
				+ priceInvoice + ", saleRetail=" + saleRetail + ", saleBlizter=" + saleBlizter + ", saleGlobal="
				+ saleGlobal + ", expirationDate=" + expirationDate + ", registrationDate=" + registrationDate
				+ ", isActive=" + isActive + ", iva=" + iva + ", genericName=" + genericName + "]";
	}
	
	
}
