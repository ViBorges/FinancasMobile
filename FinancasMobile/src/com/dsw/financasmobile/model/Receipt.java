package com.dsw.financasmobile.model;

public class Receipt {

	private String name;
	private String description;
	private float value;
	private String receiptDate;
	private String category;
	
	public Receipt(String name, String description, float value, String receiptDate,
			String category) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.receiptDate = receiptDate;
		this.category = category;
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

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String spentDate) {
		this.receiptDate = spentDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Spent [name=" + name + ", description=" + description
				+ ", value=" + value + ", spentDate=" + receiptDate
				+ ", category=" + category + "]";
	}
}
