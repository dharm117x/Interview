package com.example.asso.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@Version
	private Long version;

	private String pssno;
	private Date expirDate;

    @OneToOne(mappedBy = "passport")
    private Student student;
    
    public Passport() {
	}
    
	public Passport(String pssno, Date expirDate) {
		this.pssno = pssno;
		this.expirDate = expirDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getPssno() {
		return pssno;
	}

	public void setPssno(String pssno) {
		this.pssno = pssno;
	}

	public Date getExpirDate() {
		return expirDate;
	}

	public void setExpirDate(Date expirDate) {
		this.expirDate = expirDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

}
