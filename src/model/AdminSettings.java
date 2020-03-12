package model;

import javax.servlet.http.Part;

public class AdminSettings {
	private int id;
	private String username;
	private String password;
	private String fontColor;
	private String color1;
	private String color2;
	private String vision;
	private String mission;
	private String goals;
	private String objectives;
	private String evaluation;
	private String ratingScale;
	private String salarySchedule;
	private String officeAddress;
	private String emailAddress;
	private String contactNumber;
	private String schoolName;
	private String emailDomain;
	private Part logo;
	private byte[] logoB;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	public String getColor1() {
		return color1;
	}
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	public String getColor2() {
		return color2;
	}
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	public String getVision() {
		return vision;
	}
	public void setVision(String vision) {
		this.vision = vision;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getObjectives() {
		return objectives;
	}
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getRatingScale() {
		return ratingScale;
	}
	public void setRatingScale(String ratingScale) {
		this.ratingScale = ratingScale;
	}
	public String getSalarySchedule() {
		return salarySchedule;
	}
	public void setSalarySchedule(String salarySchedule) {
		this.salarySchedule = salarySchedule;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public Part getLogo() {
		return logo;
	}
	public void setLogo(Part logo) {
		this.logo = logo;
	}
	public byte[] getLogoB() {
		return logoB;
	}
	public void setLogoB(byte[] logoB) {
		this.logoB = logoB;
	}
}
