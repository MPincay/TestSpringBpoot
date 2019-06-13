package com.conecel.testspringboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PERSONAS", schema = "CREDITENGINE")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CEDULA")
	private String identificationId;
	@Column(name = "NOMBRES")
	private String name; 
	@Column(name = "APELLIDOS")
	private String lastName; 
	@Column(name = "EDAD")
	private int age;
	@Column(name = "ESTADO")
	private String state; 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_REGISTRO")
	private Date registerDate; 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_MODIFICACION")
	private Date modificationdate;
	public String getIdentificationId() {
		return identificationId;
	}
	public void setIdentificationId(String identificationId) {
		this.identificationId = identificationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getModificationdate() {
		return modificationdate;
	}
	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	} 
	
	
	
	
	
	
}