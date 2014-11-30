package com.dsw.financasmobile.model;

@SuppressWarnings("serial")
public class User extends Exception{

	private String name;
	private String password;
	private String confirmPassword;
	
	public User() {

	}
	
	public User(String name, String password, String confirmPassword)  throws IllegalArgumentException {
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) throws IllegalArgumentException {
	    
        if (confirmPassword != null && !confirmPassword.equals("")) {
        	this.confirmPassword = confirmPassword;
            
        } else {
            throw new IllegalArgumentException("Por favor, confirme sua senha.");
            
        }
    
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
	    
        if (name != null && !name.equals("")) {
        	this.name = name;
            
        } else {
            throw new IllegalArgumentException("Pessoa n�o pode ter nome vazio ou nulo.");
            
        }
    
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password)throws IllegalArgumentException {
	    
        if (password != null && !password.equals("")) {
        	this.password = password;
            
        } else {
            throw new IllegalArgumentException("Pessoa n�o pode ter senha vazia ou nula.");
            
        }
    
	}

	public boolean validaNome(String name){
		
		if(name.length() > 30){
			return false;
			
		}
		return true;
		
	}
	
	public boolean validaSenha(String password){
		
		if(password.length() > 6){
			return false;
			
		}
		return true;
		
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}
}
