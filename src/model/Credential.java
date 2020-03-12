package model;

import javax.servlet.http.Part;

public class Credential {
	private String credId;
	private String timestamp;
	private String empId;
	private String category;
	private String type;
	private String subtype;
	private String title;
	private Part document;
	private byte[] documentB;
	private int score;
	private String status;
	private String evaluatorId;
	private String remarks;
	private String appId;
	
	public String getCredId() {
		return credId;
	}
	public void setCredId(String credId) {
		this.credId = credId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Part getDocument() {
		return document;
	}
	public void setDocument(Part document) {
		this.document = document;
	}
	public byte[] getDocumentB() {
		return documentB;
	}
	public void setDocumentB(byte[] documentB) {
		this.documentB = documentB;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEvaluatorId() {
		return evaluatorId;
	}
	public void setEvaluatorId(String evaluatorId) {
		this.evaluatorId = evaluatorId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
}
