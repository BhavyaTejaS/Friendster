package com.app.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Job_s180396")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String jobTitle;
private String jobDescription;
private String skillsRequried;
private String location;
private String salary;
private String companyName;
private String yrsofExp;
private Date postedOn;
private boolean active;//admin the updates field active false/true other users cannot view the job with value as false
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public String getSkillsRequried() {
	return skillsRequried;
}
public void setSkillsRequried(String skillsRequried) {
	this.skillsRequried = skillsRequried;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public Date getPostedOn() {
	return postedOn;
}
public void setPostedOn(Date postedOn) {
	this.postedOn = postedOn;
}
public String getYrsofExp() {
	return yrsofExp;
}
public void setYrsofExp(String yrsofExp) {
	this.yrsofExp = yrsofExp;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}


}
