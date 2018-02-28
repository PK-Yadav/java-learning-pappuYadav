package com.java.learning.tasks.documents;

import com.java.learning.tasks.annotation.*;
import com.java.learning.tasks.common.ValidatorEnum;

import java.io.Serializable;
import java.util.Date;

@DocDataConsistency
public class PanCard implements Serializable {

	private static final long serialVersionUID = -533077700645237312L;

	@FieldValidator(type = ValidatorEnum.IDENTIFIER)
	@NotNull private String firstName;

	@NotNull
	@FieldValidator(type = ValidatorEnum.IDENTIFIER)
	private String lastName;

	@FieldValidator(type = ValidatorEnum.IDENTIFIER)
	private String middileName;

	@NotNull
	@FieldValidator(type = ValidatorEnum.PAN)
	private String panNumber;

	@NotNull @FieldValidator(type = ValidatorEnum.MOBILE) private String mobNumber;

	@FieldValidator(type = ValidatorEnum.EMAIL) @NotNull private String email;

	private Date dob;

	public PanCard(String firstName, String middileName, String lastName, String panNumber, String mobNumber, String email, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middileName = middileName;
		this.panNumber = panNumber;
		this.email = email;
		this.mobNumber = mobNumber;
		this.dob = dob;
	}

	public PanCard(){

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}