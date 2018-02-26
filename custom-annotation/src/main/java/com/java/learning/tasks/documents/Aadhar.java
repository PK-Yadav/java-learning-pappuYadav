package com.java.learning.tasks.documents;

import com.java.learning.tasks.annotation.*;
import com.java.learning.tasks.common.ValidatorEnum;

import java.io.Serializable;
import java.util.Date;

public class Aadhar implements Serializable{
	private static final long serialVersionUID = -533077700645232345L;

	@NotNull @FieldValidator(type = ValidatorEnum.IDENTIFIER)
	private String firstName;

	@NotNull @FieldValidator(type = ValidatorEnum.IDENTIFIER)
	private String lastName;

	@FieldValidator(type = ValidatorEnum.IDENTIFIER)
	private String middileName;

	@FieldValidator(type = ValidatorEnum.AADHAR)
	@NotNull private String aadharNumber;

	@NotNull @FieldValidator( type = ValidatorEnum.MOBILE) private String mobNumber;

	@FieldValidator(type = ValidatorEnum.EMAIL) @NotNull private String email;

	private Date dob;

	public Aadhar(String firstName, String middileName, String lastName, String aadharNumber, String mobNumber, String email, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middileName = middileName;
		this.aadharNumber = aadharNumber;
		this.email = email;
		this.mobNumber = mobNumber;
		this.dob = dob;
	}

	public Aadhar(){

	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	public String getMiddileName() {
		return middileName;
	}

	public void setMiddileName(String middileName) {
		middileName = middileName;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}