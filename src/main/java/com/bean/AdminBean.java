package com.bean;


import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdminBean {

	private int aId;

	@Size(min = 1, max = 10, message = "pls check size min 1 max 10*")
	private String aName;
	
	//@Email
	@Pattern(regexp="^(.+)@(.+)$",message="invalid email..")
	private String aEmail;
	private String aPassword;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

}
