package com.tnsif.placement;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Placement 
{
    private Long id;
    private String companyname;
    private String job_Title;
    private LocalDate placement_Date;
    private Long student_Id;
    public Placement()
    {
    	
    }
	public Placement(Long id, String companyname, String jobTitle, LocalDate placementDate, Long studentId) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.job_Title = jobTitle;
		this.placement_Date = placementDate;
		this.student_Id = studentId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getJob_Title() {
		return job_Title;
	}
	public void setJob_Title(String job_Title) {
		this.job_Title = job_Title;
	}
	public LocalDate getPlacement_Date() {
		return placement_Date;
	}
	public void setPlacement_Date(LocalDate placement_Date) {
		this.placement_Date = placement_Date;
	}
	public Long getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(Long student_Id) {
		this.student_Id = student_Id;
	}

    
    
}
