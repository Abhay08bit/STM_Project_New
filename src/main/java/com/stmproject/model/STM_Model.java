package com.stmproject.model;

import java.util.Date;

public class STM_Model {
	
    private String stmNo;

    private String stmVersion;

    private String linkDestination;

    private String textShortJP;

    private String textShortEN;

//    private String pdfFile;
//
//    private String wordFile;

    private Date draftingDate;

    private String finalDrafterName;

    private String oldSTMNumber;

    private String remarks1;

    private String note2;

    private String note3;

    private String creatorSSOID;
    
    public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	private Boolean isDeleted;
    
    public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	private Date lastUpdated;
    
    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	private Date createdDate;
    
    public String getStmNo() {
		return stmNo;
	}

	public void setStmNo(String stmNo) {
		this.stmNo = stmNo;
	}

	public String getStmVersion() {
		return stmVersion;
	}

	public void setStmVersion(String stmVersion) {
		this.stmVersion = stmVersion;
	}

	public String getLinkDestination() {
		return linkDestination;
	}

	public void setLinkDestination(String linkDestination) {
		this.linkDestination = linkDestination;
	}

	public String getTextShortJP() {
		return textShortJP;
	}

	public void setTextShortJP(String textShortJP) {
		this.textShortJP = textShortJP;
	}

	public String getTextShortEN() {
		return textShortEN;
	}

	public void setTextShortEN(String textShortEN) {
		this.textShortEN = textShortEN;
	}

//	public String getPdfFile() {
//		return pdfFile;
//	}
//
//	public void setPdfFile(String pdfFile) {
//		this.pdfFile = pdfFile;
//	}
//
//	public String getWordFile() {
//		return wordFile;
//	}
//
//	public void setWordFile(String wordFile) {
//		this.wordFile = wordFile;
//	}

	public Date getDraftingDate() {
		return draftingDate;
	}

	public void setDraftingDate(Date draftingDate) {
		this.draftingDate = draftingDate;
	}

	public String getFinalDrafterName() {
		return finalDrafterName;
	}

	public void setFinalDrafterName(String finalDrafterName) {
		this.finalDrafterName = finalDrafterName;
	}

	public String getOldSTMNumber() {
		return oldSTMNumber;
	}

	public void setOldSTMNumber(String oldSTMNumber) {
		this.oldSTMNumber = oldSTMNumber;
	}

	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getNote3() {
		return note3;
	}

	public void setNote3(String note3) {
		this.note3 = note3;
	}

	public String getCreatorSSOID() {
		return creatorSSOID;
	}

	public void setCreatorSSOID(String creatorSSOID) {
		this.creatorSSOID = creatorSSOID;
	}

	

}
