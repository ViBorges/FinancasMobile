package com.dsw.financasmobile.model;

@SuppressWarnings("serial")
public class Data extends Exception {

	private String name;
	private String description;
	private float value;
	private String year;
	private String month;
	private String category;

	public Data(String name, String description, float value,
			String year, String month, String category) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.year = year;
		this.month = month;
		this.category = category;
	}

	public Data() {

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {

		if (name != null && !name.equals("")) {
			this.name = name;
		} else {
			throw new IllegalArgumentException(
					"Gasto nao pode ter nome vazio ou nulo.");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description)
			throws IllegalArgumentException {

		if (description != null && !description.equals("")) {
			this.description = description;
		} else {
			throw new IllegalArgumentException(
				"Gasto nao pode ter descricao vazia ou nula.");
		}
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) throws IllegalArgumentException {

		if (value != 0.0) {
			this.value = value;

		} else {
			throw new IllegalArgumentException(
				"Gasto nao pode ter valor vazio ou nulo.");
		}
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) throws IllegalArgumentException {

		if (!year.equals("")) {
			this.year = year;
		} else {
			throw new IllegalArgumentException(
				"O ano nao pode ser valor vazio ou nulo.");
		}
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) throws IllegalArgumentException {

		if (!month.equals("")) {
			this.month = month;
		} else {
			throw new IllegalArgumentException(
				"O mes nao pode ser vazio ou nulo.");
		}
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) throws IllegalArgumentException {

		if (!category.equals("")) {
			this.category = category;
		} else {
			throw new IllegalArgumentException("Gasto nao pode ter valor vazio ou nulo.");
		}
	}

	@Override
	public String toString() {
		return "Spent [name=" + name + ", description=" + description
				+ ", value=" + value + ", spentDate=" + year
				+ ", month=" + month + ", category=" + category + "]";
	}
}