package com.stmproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="STM_Histo")
public class STM_Histo {
	
	
	 public STM_Histo() {
			super();
		}
	    
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "No")
    private Integer no;

    @Column(name = "STM_No", columnDefinition = "NVARCHAR(15)",nullable = false)
    private String stmNo;

    @Column(name = "STM_Version", length = 4)
    private String stmVersion;

    @Column(name = "Link_Destination", columnDefinition = "NVARCHAR(15)")
    private String linkDestination;

    @Column(name = "Text_Short_JP", columnDefinition = "NVARCHAR(200)")
    private String textShortJP;

    @Column(name = "Text_Short_EN", columnDefinition = "NVARCHAR(200)")
    private String textShortEN;

    @Column(name = "Pdf_File", columnDefinition = "NVARCHAR(25)")
    private String pdfFile;

    @Column(name = "Word_File", columnDefinition = "NVARCHAR(25)")
    private String wordFile;

    @Column(name = "Drafting_Date")
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date draftingDate;

    @Column(name = "Final_Drafter_Name",columnDefinition = "NVARCHAR(100)")
    private String finalDrafterName;

    @Column(name = "Old_STM_Number", columnDefinition = "NVARCHAR(15)")
    private String oldSTMNumber;

    @Column(name = "Remarks1", columnDefinition = "NVARCHAR(200)")
    private String remarks1;

    @Column(name = "Note2", columnDefinition = "NVARCHAR(200)")
    private String note2;

    @Column(name = "Note3", columnDefinition = "NVARCHAR(200)")
    private String note3;

    @Column(name = "Creator_SSO_ID", columnDefinition = "NVARCHAR(11)",nullable = false)
    private String creatorSSOID;

    @Column(name = "Created_date",nullable = false)
    private Date createdDate;

    @Column(name = "Last_Updated")
    private Date lastUpdated;
    
   
    public STM_Histo(Integer no, String stmNo, String stmVersion, String linkDestination, String textShortJP,
			String textShortEN, String pdfFile, String wordFile, Date draftingDate, String finalDrafterName,
			String oldSTMNumber, String remarks1, String note2, String note3, String creatorSSOID, Date createdDate,
			Date lastUpdated, boolean isDeleted) {
		super();
		this.no = no;
		this.stmNo = stmNo;
		this.stmVersion = stmVersion;
		this.linkDestination = linkDestination;
		this.textShortJP = textShortJP;
		this.textShortEN = textShortEN;
		this.pdfFile = pdfFile;
		this.wordFile = wordFile;
		this.draftingDate = draftingDate;
		this.finalDrafterName = finalDrafterName;
		this.oldSTMNumber = oldSTMNumber;
		this.remarks1 = remarks1;
		this.note2 = note2;
		this.note3 = note3;
		this.creatorSSOID = creatorSSOID;
		this.createdDate = createdDate;
		this.lastUpdated = lastUpdated;
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "STM_Histo [no=" + no + ", stmNo=" + stmNo + ", stmVersion=" + stmVersion + ", linkDestination="
				+ linkDestination + ", textShortJP=" + textShortJP + ", textShortEN=" + textShortEN + ", pdfFile="
				+ pdfFile + ", wordFile=" + wordFile + ", draftingDate=" + draftingDate + ", finalDrafterName="
				+ finalDrafterName + ", oldSTMNumber=" + oldSTMNumber + ", remarks1=" + remarks1 + ", note2=" + note2
				+ ", note3=" + note3 + ", creatorSSOID=" + creatorSSOID + ", createdDate=" + createdDate
				+ ", lastUpdated=" + lastUpdated + ", isDeleted=" + isDeleted + ", getNo()=" + getNo() + ", getStmNo()="
				+ getStmNo() + ", getStmVersion()=" + getStmVersion() + ", getLinkDestination()=" + getLinkDestination()
				+ ", getTextShortJP()=" + getTextShortJP() + ", getTextShortEN()=" + getTextShortEN()
				+ ", getPdfFile()=" + getPdfFile() + ", getWordFile()=" + getWordFile() + ", getDraftingDate()="
				+ getDraftingDate() + ", getFinalDrafterName()=" + getFinalDrafterName() + ", getOldSTMNumber()="
				+ getOldSTMNumber() + ", getRemarks1()=" + getRemarks1() + ", getNote2()=" + getNote2()
				+ ", getNote3()=" + getNote3() + ", getCreatorSSOID()=" + getCreatorSSOID() + ", getCreatedDate()="
				+ getCreatedDate() + ", getLastUpdated()=" + getLastUpdated() + ", isDeleted()=" + isDeleted()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

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

	public String getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(String pdfFile) {
		this.pdfFile = pdfFile;
	}

	public String getWordFile() {
		return wordFile;
	}

	public void setWordFile(String wordFile) {
		this.wordFile = wordFile;
	}

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "Is_deleted")
    private boolean isDeleted;

}
