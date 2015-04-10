package com.salesorderapp.hibernate.entity;

// default package
// Generated 28 Dec, 2014 2:51:29 PM by Hibernate Tools 4.0.0

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author freakster
 */
@Entity
@Table(name = "Student", catalog = "salesorderschema")
public class Student implements java.io.Serializable {

	private Integer idStudent;
	private String studentName;
	private Integer studentAge;

	public Student() {
	}

	public Student(String studentName, Integer studentAge) {
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idStudent", unique = true, nullable = false)
	public Integer getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	@Column(name = "StudentName", length = 45)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "StudentAge")
	public Integer getStudentAge() {
		return this.studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}

}
