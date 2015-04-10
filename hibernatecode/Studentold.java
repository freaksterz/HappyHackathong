package com.salesorderapp.hibernate.dto;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "Student")
public class Studentold implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStudent;
	
	@Column(name ="StudentName")
	private String StudentName;
	
	private @Column(name ="StudentAge")
	int StudentAge;
	
	
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getStudentAge() {
		return StudentAge;
	}
	public void setStudentAge(int studentAge) {
		StudentAge = studentAge;
	}
	
		@Override
	    public String toString() {
	        return "Student [id=" + idStudent + ", studentName = " + StudentName + ", studentAge=" +StudentAge + "]";
	    }

} 
