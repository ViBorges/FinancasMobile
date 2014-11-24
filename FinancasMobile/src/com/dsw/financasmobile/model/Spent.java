package com.dsw.financasmobile.model;


public class Spent extends Exception{
	
	private String name;
	private String description;
	private float value;
	private int spentDate;
	private String category;
	
	
	public Spent(String name, String description, float value, int spentDate,
			String category) {
		super();
		this.name = name;
		this.description = description;
		this.value = value;
		this.spentDate = spentDate;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
	    
        if (name != null && !name.equals("")) {
        	this.name = name;
            
        } else {
            throw new IllegalArgumentException("Gasto não pode ter nome vazio ou nulo.");
        }
        
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws IllegalArgumentException {
	    
        if (description != null && !description.equals("")) {
        	this.description = description;
            
        } else {
            throw new IllegalArgumentException("Gasto não pode ter descrição vazia ou nula.");
        }
        
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) throws IllegalArgumentException {
	    
        if (value != 0.0) {
        	this.value = value;
            
        } else {
            throw new IllegalArgumentException("Gasto não pode ter valor vazio ou nulo.");
        }
       
	}

	public int getSpentDate() {
		return spentDate;
	}

	public void setSpentDate(int spentDate)throws IllegalArgumentException {
	    
        if (spentDate != 0) {
        	this.spentDate = spentDate;
            
        } else {
            throw new IllegalArgumentException("Gasto não pode ter data vazio ou nulo.");
        } 
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) throws IllegalArgumentException {
	    
        if (category != null || !category.equals("")) {
        	this.category = category;
            
        } else {
            throw new IllegalArgumentException("Gasto não pode ter valor vazio ou nulo.");
        } 
	}

	@Override
	public String toString() {
		return "Spent [name=" + name + ", description=" + description
				+ ", value=" + value + ", spentDate=" + spentDate
				+ ", category=" + category + "]";
	}
	
}
