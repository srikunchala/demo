package com.example.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "studentsmarks")
public class Student {

	@Column(name = "user_id")
	private int studId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@Column(name = "maths")
	private Double maths;
	@Column(name = "physics")
	private Double physics;
	@Column(name = "biology")
	private Double biology;
	@Column(name = "chemistry")
	private Double chemistry;

	@Column(name = "total")
	private Double total;

	@Column(name = "rank")
	private Double rank;

	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "LAST_MODIFIED_DATE", nullable = false)
//	@Basic(fetch = FetchType.EAGER)
//
//	
//	Calendar lastModifiedDate;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "LAST_MODIFIED_DATE", nullable = false)
//	@Basic(fetch = FetchType.EAGER)

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "examdate")
	private Calendar examdate;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getMaths() {
		return maths;
	}

	public void setMaths(Double maths) {
		this.maths = maths;
	}

	public Double getPhysics() {
		return physics;
	}

	public void setPhysics(Double physics) {
		this.physics = physics;
	}

	public Double getBiology() {
		return biology;
	}

	public void setBiology(Double biology) {
		this.biology = biology;
	}

	public Double getChemistry() {
		return chemistry;
	}

	public void setChemistry(Double chemistry) {
		this.chemistry = chemistry;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getRank() {
		return rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public Calendar getExamdate() {
		return examdate;
	}

	public void setExamdate(Calendar examdate) {
		this.examdate = examdate;
	}

	 
}
