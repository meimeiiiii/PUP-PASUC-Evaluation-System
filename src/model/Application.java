package model;

import javax.servlet.http.Part;

public class Application {
	private String appId;
	private String dtSubmitted;
	private int scoreEduc;
	private int scoreExp;
	private int scoreProf;
	private int total;
	private String curRank;
	private String newRank;
	private Part document;
	private byte[] documentB;
	private String evaluatorId;
	private String dtApproved;
	private String status;
	private String remarks;
	private String empId;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getDtSubmitted() {
		return dtSubmitted;
	}
	public void setDtSubmitted(String dtSubmitted) {
		this.dtSubmitted = dtSubmitted;
	}
	public int getScoreEduc() {
		return scoreEduc;
	}
	public void setScoreEduc(int scoreEduc) {
		this.scoreEduc = scoreEduc;
	}
	public int getScoreExp() {
		return scoreExp;
	}
	public void setScoreExp(int scoreExp) {
		this.scoreExp = scoreExp;
	}
	public int getScoreProf() {
		return scoreProf;
	}
	public void setScoreProf(int scoreProf) {
		this.scoreProf = scoreProf;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCurRank() {
		return curRank;
	}
	public void setCurRank(String curRank) {
		this.curRank = curRank;
	}
	public String getNewRank() {
		return newRank;
	}
	public void setNewRank(String newRank) {
		this.newRank = newRank;
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
	public String getEvaluatorId() {
		return evaluatorId;
	}
	public void setEvaluatorId(String evaluatorId) {
		this.evaluatorId = evaluatorId;
	}
	public String getDtApproved() {
		return dtApproved;
	}
	public void setDtApproved(String dtApproved) {
		this.dtApproved = dtApproved;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
