package com.nttdata.hibernate.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity Customer
 * 
 * @author Samuel Calderón Gonález
 *
 */
@Entity
@Table(name = "cliente")
public class Customer extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname1;
	private String surname2;
	private String nif;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "nombre")
	public String getName() {
		return name;
	}

	@Column(name = "apellido1")
	public String getSurname1() {
		return surname1;
	}

	@Column(name = "apellido2")
	public String getSurname2() {
		return surname2;
	}

	@Column(name = "dni")
	public String getNif() {
		return nif;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname1=" + surname1 + ", surname2=" + surname2 + ", nif="
				+ nif + "]";
	}

}
