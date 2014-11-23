package com.dsw.financasmobile.model;

public class Spent {
	
	private String name;
	private String description;
	private float value;
	private String spentDate;
	private String category;
	
	public Spent(String name, String description, float value, String spentDate,
			String category) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.spentDate = spentDate;
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

	public String getSpentDate() {
		return spentDate;
	}

	public void setSpentDate(String spentDate) {
		this.spentDate = spentDate;
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
				+ ", value=" + value + ", spentDate=" + spentDate
				+ ", category=" + category + "]";
	}
	
}
